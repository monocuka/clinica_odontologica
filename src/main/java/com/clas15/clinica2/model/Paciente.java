package com.clas15.clinica2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Pacientes")
public class Paciente {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    //private Domicilio domicilio;
    private String usuario;
    private String password;

    private LocalDate fechaNacimiento;

   // @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   // @JoinColumn(name="domi_id")





   // @JsonIgnore
    //@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //private Set<Turno> turnos ;

    public Paciente(Integer id, String nombre, String apellido, String dni, Date fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;

    }

    public Paciente(String nombre, String apellido, String dni, Date fechaIngreso) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;

    }




   // public Set<Turno> getTurno() {
    //    return turnos;}

   // public void setTurno(Set<Turno> turno) {
    //this.turnos = turno;}

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

  //  public Domicilio getDomicilio() {
    //    return domicilio;
    //}

    //public void setDomicilio(Domicilio domicilio) {
        //this.domicilio = domicilio;
  // }


    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
