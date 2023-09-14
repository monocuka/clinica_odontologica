package com.clas15.clinica2.controller.implement;

import com.clas15.clinica2.controller.ControllerCRUDInterface;
import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.exceptions.ResourceNotFoundException;
import com.clas15.clinica2.model.Paciente;
import com.clas15.clinica2.service.Implementation.PacienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pacientes")
public class PacienteController implements ControllerCRUDInterface<Paciente> {

    private static final Logger LOGGER= Logger.getLogger(PacienteController.class);
    @Autowired
    PacienteService pacienteService;

    @PostMapping("/")
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) throws BadRequestException {
        return new ResponseEntity<>(pacienteService.guardar(paciente), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable("id") Integer id) throws BadRequestException, ResourceNotFoundException {
        Paciente paciente = pacienteService.buscar(id);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable("id") Integer id) throws BadRequestException, ResourceNotFoundException {
        pacienteService.eliminar(id);
        return ResponseEntity.ok(("Se eliminó el Paciente con id " + id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Paciente>>buscarTodos() throws ResourceNotFoundException, JsonProcessingException {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
    @PutMapping("/")
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(pacienteService.actualizar(paciente));
    }

}
