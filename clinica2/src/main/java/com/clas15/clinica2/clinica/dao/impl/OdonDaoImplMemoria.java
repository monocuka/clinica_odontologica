package com.clas15.clinica2.clinica.dao.impl;

import com.clas15.clinica2.clinica.model.Odontologo;
import com.clas15.clinica2.clinica.dao.IDao;
import com.clas15.clinica2.clinica.model.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdonDaoImplMemoria implements IDao<Odontologo> {

    private ArrayList<Odontologo> odontologosEnMemoria = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo o) {
        o.setId(odontologosEnMemoria.size()+1);
        odontologosEnMemoria.add(o);
        return o;
    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        return null;
    }

    @Override
    public ArrayList<Odontologo> listar() {
        return odontologosEnMemoria;
    }
}
