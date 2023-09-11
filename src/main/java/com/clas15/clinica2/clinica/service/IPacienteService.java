package com.clas15.clinica2.clinica.service;

import com.clas15.clinica2.clinica.model.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerPaciente(Integer id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Integer id);

    Set<PacienteDTO> getTodos();

}
