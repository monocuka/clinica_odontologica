package com.clas15.clinica2.clinica.service;

import com.clas15.clinica2.clinica.dao.IDao;
import com.clas15.clinica2.clinica.model.Paciente;

import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p){
        return pacienteIDao.guardar(p);
    }
    public Paciente buscar(int id){
        return pacienteIDao.buscar(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }
    public void eliminar(int id){
         pacienteIDao.eliminar(id);
    }
}
