package com.clas15.clinica2.controller.implement;


import com.clas15.clinica2.controller.ControllerCRUDInterface;
import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.exceptions.ResourceNotFoundException;
import com.clas15.clinica2.model.Odontologo;
import com.clas15.clinica2.service.Implementation.OdontologoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Odontologos")
public class OdontologoController implements ControllerCRUDInterface<Odontologo> {

    @Autowired
    OdontologoService odontologoService;


    @PostMapping("/")
    public ResponseEntity<Odontologo> guardar(Odontologo odontologo) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        return new ResponseEntity<>(odontologoService.guardar(odontologo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable("id") Integer id) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        Odontologo odontologo = odontologoService.buscar(id);
        return ResponseEntity.ok(odontologo);
    }

    @PutMapping("/")
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) throws BadRequestException, ResourceNotFoundException, JsonProcessingException {
        return ResponseEntity.ok(odontologoService.actualizar(odontologo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Odontologo> eliminarPorId(@PathVariable("id") Integer id) throws BadRequestException, ResourceNotFoundException {
        odontologoService.eliminar(id);
        return ResponseEntity.ok(("eliminado el odontologo" + id););
    }

    @GetMapping("/")
    public ResponseEntity<List<Odontologo>> buscarTodos() throws ResourceNotFoundException, JsonProcessingException {
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }
}

