package com.clas15.clinica2.service.Implementation;

import com.clas15.clinica2.DaoRepository.ITurnoRepository;
import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.exceptions.ResourceNotFoundException;
import com.clas15.clinica2.model.Odontologo;
import com.clas15.clinica2.model.Paciente;
import com.clas15.clinica2.model.Turno;
import com.clas15.clinica2.service.ICrudInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Turnoservice implements ICrudInterface<Turno> {
    private static final Logger LOGGER= Logger.getLogger(Turnoservice.class);

    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


    @Override
    public Turno guardar(Turno turno) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        LOGGER.info("Guardar turno");
        Paciente pacienteValido=pacienteService.buscar(turno.getPaciente().getId());
        Odontologo odontologoValido=odontologoService.buscar(turno.getOdontologo().getOdontologo_id());
        //se valida que pasa la info de paciente y odontologo
        if (turno.getPaciente() == null || turno.getOdontologo() == null) {
            throw new BadRequestException("El paciente o el odontólogo no pueden ser nulos o deben existir en la base de datos");
        }
        //chequeo que sean odontologo y paciente valido en la bbdd
        if ( pacienteValido== null && odontologoValido == null) {
            throw new ResourceNotFoundException("No se encontró el paciente o el odontólogo");
        }
        else {

            turno.setPaciente(pacienteValido);
            turno.setOdontologo(odontologoValido);
            turno=turnoRepository.save(turno);
        }
        return turno;
    }


    @Override
    public Turno buscar(Integer id) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        LOGGER.info("Buscando turno");
        if (id == null || id < 1) {
            throw new BadRequestException("El id no puede ser nulo o negativo");
        }
        Turno turno = turnoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No se encontró el turno con id " + id));
        return turno;
    }

    @Override
    public void eliminar(Integer id) throws BadRequestException, ResourceNotFoundException {
        LOGGER.info("Eliminando turno");
        if (id == null || id < 1) {
            throw new BadRequestException("El id debe ser positivo y nonull ");
        }
        Turno turno = turnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + "este id no tiene un turno " ));
        turnoRepository.delete(turno);
    }

    @Override
    public Turno actualizar(Turno turno) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        LOGGER.info("Actualizando turno");
        if (turno.getId() == null || turno.getId() < 1) {
            throw new BadRequestException("El id debe ser positivo y nonull");
        }
        if (turno.getPaciente() == null || turno.getOdontologo() == null) {
            throw new BadRequestException("odontologo y paciente deben exisitir en la base de datos ");
        }
        if (this.buscar(turno.getId()) == null) {
            throw new ResourceNotFoundException("No se encontró el turno con id " + turno.getId());
        }
        if(pacienteService.buscar(turno.getPaciente().getId())==null){
            throw new ResourceNotFoundException("No se encontró el paciente " + turno.getPaciente().getId());
        }
        if(odontologoService.buscar(turno.getOdontologo().getOdontologo_id())==null){
            throw new ResourceNotFoundException("No se encontró el odontologo con id " + turno.getOdontologo().getOdontologo_id());
        }
        turno.setPaciente(pacienteService.buscar(turno.getPaciente().getId()));
        turno.setOdontologo(odontologoService.buscar(turno.getOdontologo().getOdontologo_id()));
        return turno = turnoRepository.save(turno);
    }

    @Override
    public List<Turno> buscarTodos() throws JsonProcessingException, ResourceNotFoundException {
        LOGGER.info("Buscando todos los turnos");
        List<Turno> turnos = turnoRepository.findAll();
        return turnos;
    }
}
