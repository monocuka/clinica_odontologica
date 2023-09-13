package com.clas15.clinica2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date fechaCita;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="paciente_id", nullable = false)
    private Paciente paciente;

    public Turno(Integer id, Date fechaCita, Odontologo odontologo, Paciente paciente) {
        this.id = id;
        this.fechaCita = fechaCita;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public Turno(Date fechaCita, Odontologo odontologo, Paciente paciente) {
        this.fechaCita = fechaCita;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    } 

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
