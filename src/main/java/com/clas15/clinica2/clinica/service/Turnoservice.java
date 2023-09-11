package com.clas15.clinica2.clinica.service;

import com.clas15.clinica2.clinica.DaoRepository.ITurnoRepository;
import com.clas15.clinica2.clinica.model.Turno;
import com.clas15.clinica2.clinica.model.TurnoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class Turnoservice implements ITurnoService {
    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;


    private void guardarTurno(TurnoDTO turnoDTO){

        Turno turno = mapper.convertValue(turnoDTO, Turno.class); //convierte pacienteDTO en un objeto de tipo Paciente.
        turnoRepository.save(turno);
    }
    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO leerTurno(Integer id) {
        Optional<Turno> turno = turnoRepository.findById(id); //nos devuelve un paciente por su id. optional per mite preguntar si este objeto tiene o njo contenido.
        TurnoDTO turnoDTO = null;
        if(turno.isPresent())
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Integer id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> getTodos() {
        List<Turno> turnos = turnoRepository.findAll();

        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for (Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return turnosDTO;
    }
}
