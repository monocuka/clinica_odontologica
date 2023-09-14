package com.clas15.clinica2.service.Implementation;


import com.clas15.clinica2.DaoRepository.IOdontologoRepository;
import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.exceptions.ResourceNotFoundException;
import com.clas15.clinica2.model.Odontologo;
import com.clas15.clinica2.service.ICrudInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements ICrudInterface<Odontologo> {

  private static final Logger LOGGER= Logger.getLogger(OdontologoService.class);

  @Autowired
    private IOdontologoRepository odontologoRepository;

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    @Override
    public Odontologo guardar(Odontologo odontologo) throws BadRequestException {
        LOGGER.info("Guardando odontologo");
        if(odontologo==null)
            throw new BadRequestException("El odontologo no puede ser nulo");
            return odontologoRepository.save(odontologo);
    }
    @Override
    public void eliminar(Integer id) throws BadRequestException, ResourceNotFoundException {
        LOGGER.info("Eliminando odontologo");
        if (id == null || id < 1) {
            throw new BadRequestException("El id no puede ser nulo o negativo");
        }
        if (odontologoRepository.findById(id).isPresent()) {
            odontologoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No se encontró el odontólogo con id " + id);
        }
    }
    @Override
    public Odontologo actualizar(Odontologo odontologo) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        LOGGER.info("Actualizando odontologo");
        Odontologo odontologoActualizado;
        if (odontologo == null) {
            throw new BadRequestException("No se pudo actualizar el odontologo null");
        }
        if (odontologo.getOdontologo_id() == null || odontologo.getOdontologo_id() < 1) {
            throw new BadRequestException("El id no puede ser nulo o negativo");
        }
        if (this.buscar(odontologo.getOdontologo_id()) == null) {
            throw new ResourceNotFoundException("No se encontró el odontologo con id " + odontologo.getOdontologo_id());
        }
        return odontologoRepository.save(odontologo);
    }


    @Override
    public Odontologo buscar(Integer id) throws BadRequestException, ResourceNotFoundException {
        LOGGER.info("Buscando odontologo");
        if(id == null || id < 1){
            throw new BadRequestException("El id no puede ser nulo o menor a 1");
        }
        return odontologoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el odontólogo con id " + id));
    }
    @Override
    public List<Odontologo> buscarTodos() throws JsonProcessingException, ResourceNotFoundException {
        LOGGER.info("Buscando todos los odontologos");
        List<Odontologo> odontologos = odontologoRepository.findAll();
        if(odontologos.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron odontologos");
        }else {
            return odontologos;
        }
    }
}
