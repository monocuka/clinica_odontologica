package com.clas15.clinica2.model;

public class PacienteDTO {

    private Integer id;

    private String nombre;

    private String apellido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
       apellido = apellido;
    }
}
