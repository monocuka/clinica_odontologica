package com.clas15.clinica2.service;

import com.clas15.clinica2.model.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    void crearOdontologo (OdontologoDTO odontologoDTO);
    OdontologoDTO leerOdontologo(Integer id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Integer id);

    Set<OdontologoDTO> getTodos();
}
