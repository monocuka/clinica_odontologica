package com.clas15.clinica2.service;


import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ICrudInterface<T> {
    T guardar(T t) throws BadRequestException, ResourceNotFoundException, JsonProcessingException;
    T buscar(Integer id) throws BadRequestException, ResourceNotFoundException, JsonProcessingException;

    void eliminar(Integer id) throws BadRequestException, ResourceNotFoundException;

    T actualizar(T t) throws BadRequestException, ResourceNotFoundException, JsonProcessingException;

    List<T> buscarTodos() throws JsonProcessingException, ResourceNotFoundException;
}
