package com.clas15.clinica2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="odontologos")
public class Odontologo {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer numeroMatricula;

    private String nombre;

    private String apellido;

    private String usuario;

    private String password;

    @JsonIgnore //PARQ EU NO ENTRE EN LOOP INFINITO
    //@OneToMany(mappedBy = "Odontologo", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    //private Set<Turno> turnos = new HashSet<>();
    public Odontologo(int id, int numeroMatricula, String nombre, String apellido) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo( Integer id, Integer numeroMatricula, String nombre, String apellido) {
        this.id = 0;
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

   public Odontologo(){

   }

    public Integer getOdontologo_id() {
        return id;
    }

    public void setOdontologo_id(Integer id) {
        this.id = id;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", numeroMatricula=" + numeroMatricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
