package com.clas15.clinica2.clinica.dao;

import com.clas15.clinica2.clinica.model.Odontologo;
import com.clas15.clinica2.clinica.model.Odontologo;

import java.util.ArrayList;
import java.util.List;

public interface IDao<T> {

    public T guardar(T t);
    public T buscar(int id);
    public void eliminar(int id);
    public List<T> buscarTodos();

    ArrayList<Odontologo> listar();
}
