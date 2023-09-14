package com.clas15.clinica2.service.Implementation;

import com.clas15.clinica2.DaoRepository.IPacienteRepository;
import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.exceptions.ResourceNotFoundException;
import com.clas15.clinica2.model.Paciente;
import com.clas15.clinica2.service.ICrudInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements ICrudInterface<Paciente> {

    @Autowired
    ObjectMapper mapper;

    private static final Logger LOGGER= Logger.getLogger(PacienteService.class);

    private IPacienteRepository pacienteRepository;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    @Override
    public Paciente guardar(Paciente paciente) throws BadRequestException {
        LOGGER.info("Guardando paciente");
        if(paciente==null)
            throw new BadRequestException("El Paciente no puede ser nulo");
        return pacienteRepository.save(paciente);
    }
    @Override
    public void eliminar(Integer id) throws BadRequestException, ResourceNotFoundException {
        LOGGER.info("Eliminando paciente");
        if (id == null || id < 1) {
            throw new BadRequestException("El id no puede ser nulo o negativo");
        }
        if (pacienteRepository.findById(id).isPresent()) {
            pacienteRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No se encontró el Paciente con id " + id);
        }
    }
    @Override
    public Paciente actualizar(Paciente paciente) throws BadRequestException, ResourceNotFoundException {
        LOGGER.info("Actualizando paciente");
        Paciente odontologoActualizado;
        if (paciente == null) {
            throw new BadRequestException("No se pudo actualizar null");
        }
        if (paciente.getId() == null || paciente.getId() < 1) {
            throw new BadRequestException("El id no puede ser null");
        }
        if (this.buscar(paciente.getId()) == null) {
            throw new ResourceNotFoundException("No se encontró id paciente " + paciente.getId());
        }
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscar(Integer id) throws BadRequestException, ResourceNotFoundException {
        LOGGER.info("busca paciente");
        if(id == null || id < 1){
            throw new BadRequestException("El id no puede ser nulo y debe ser mayor 0");
        }
        return pacienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el Paciente con id " + id));
    }
    @Override
    public List<Paciente> buscarTodos() throws JsonProcessingException, ResourceNotFoundException {
        LOGGER.info("Buscando todos los pacientes");
        List<Paciente> pacientes = pacienteRepository.findAll();
        if(pacientes.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron pacientes");
        }else {
            return pacientes;
        }
    }


}
