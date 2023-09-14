package com.clas15.clinica2.controller;


import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ControllerCRUDInterface<T> {
    ResponseEntity<?> guardar(@RequestBody T t) throws BadRequestException, ResourceNotFoundException, JsonProcessingException;
    ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException, JsonProcessingException;
    ResponseEntity<?> actualizar(@RequestBody T t) throws BadRequestException, ResourceNotFoundException, JsonProcessingException;
    ResponseEntity<?> eliminarPorId(@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException;
    ResponseEntity<?> buscarTodos() throws ResourceNotFoundException,JsonProcessingException;
}

