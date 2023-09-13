package com.clas15.clinica2.service;

import com.clas15.clinica2.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO leerTurno(Integer id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Integer id);

    Set<TurnoDTO> getTodos();

}
