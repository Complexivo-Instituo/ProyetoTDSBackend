/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "asiganatura")
public class Asignatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasiganatura", nullable = false)
    private Long idasiganatura;

    @Column(name = "nombreasignatura", nullable = false)
    private String nombreasignatura;

    @Column(name = "promedio", nullable = false)
    private float promedio;

    public Asignatura() {
    }

    public Asignatura(String nombreasignatura, float promedio) {
        
        this.nombreasignatura = nombreasignatura;
        this.promedio = promedio;
    }

    public Long getIdasiganatura() {
        return idasiganatura;
    }

    public void setIdasiganatura(Long idasiganatura) {
        this.idasiganatura = idasiganatura;
    }

    public String getNombreasignatura() {
        return nombreasignatura;
    }

    public void setNombreasignatura(String nombreasignatura) {
        this.nombreasignatura = nombreasignatura;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    
    
}
