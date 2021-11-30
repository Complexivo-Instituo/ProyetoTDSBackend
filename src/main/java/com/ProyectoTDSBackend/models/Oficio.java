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
@Table(name = "oficio")
public class Oficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoficio", nullable = false)
    private Long idoficio;

    @Column(name = "fecha_oficio", nullable = false)
    private Date fecha_inicio;

    public Oficio() {
    }

    public Oficio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Long getIdoficio() {
        return idoficio;
    }

    public void setIdoficio(Long idoficio) {
        this.idoficio = idoficio;
    }

    
    
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

}
