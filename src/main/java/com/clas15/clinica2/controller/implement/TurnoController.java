package com.clas15.clinica2.controller.implement;

import com.clas15.clinica2.controller.ControllerCRUDInterface;
import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.exceptions.ResourceNotFoundException;
import com.clas15.clinica2.model.Turno;
import com.clas15.clinica2.service.Implementation.OdontologoService;
import com.clas15.clinica2.service.Implementation.PacienteService;
import com.clas15.clinica2.service.Implementation.Turnoservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Turnos")
public class TurnoController  implements ControllerCRUDInterface<Turno> {

    @Autowired
    Turnoservice turnoService;
    @Autowired
    PacienteService pacienteService;
    @Autowired
    OdontologoService odontologoService;
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable("id") Integer id) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        Turno turno = turnoService.buscar(id);
        return ResponseEntity.ok(turno);
    }

    @PostMapping("/")
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        return ResponseEntity.ok(turnoService.guardar(turno));
    }

    @PutMapping("/")
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        return ResponseEntity.ok(turnoService.actualizar(turno));
    }

    @GetMapping("/")
    public ResponseEntity<List<Turno>>buscarTodos() throws ResourceNotFoundException, JsonProcessingException {
        return ResponseEntity.ok(turnoService.buscarTodos());

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable("id") Integer id) throws BadRequestException, ResourceNotFoundException {
        turnoService.eliminar(id);
        return ResponseEntity.ok(("Se eliminó el turno con id " + id));
    }
}
