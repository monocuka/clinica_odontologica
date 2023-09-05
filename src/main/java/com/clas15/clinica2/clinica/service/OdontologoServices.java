package com.clas15.clinica2.clinica.service;


import org.apache.log4j.Logger;
import com.clas15.clinica2.clinica.dao.IDao;
import com.clas15.clinica2.clinica.model.Odontologo;

import java.util.ArrayList;



public class OdontologoServices {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OdontologoServices.class));

    private IDao<Odontologo> odonDao;

    public OdontologoServices(IDao<Odontologo> odonDao) {
        this.odonDao = odonDao;
    }

    public Odontologo guardar(Odontologo o){
        LOGGER.info("Grabando Odontologo:"+o);
        return odonDao.guardar(o);
    }

    public ArrayList<Odontologo> todos(){
        LOGGER.info("Lista Odontologos");
        return odonDao.listar();
    }
}
