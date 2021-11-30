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
@Table(name = "convocatoria")
public class Convocatoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconvocatoria", nullable = false)
    private Long idconvocatoria;

    @Column(name = "descripcion_convocatoria", nullable = false)
    private String descripcion_convocatoria;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private Date fecha_fin;

    @Column(name = "estado" )
    private int estado;

    public Convocatoria() {
    }

    public Convocatoria(Long idconvocatoria, String descripcion_convocatoria, Date fecha_inicio, Date fecha_fin, Integer estado) {
        this.idconvocatoria = idconvocatoria;
        this.descripcion_convocatoria = descripcion_convocatoria;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public Convocatoria(String descripcion_convocatoria, Date fecha_inicio, Date fecha_fin) {
        this.descripcion_convocatoria = descripcion_convocatoria;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    

    
    
    public Long getIdconvocatoria() {
        return idconvocatoria;
    }

    public void setIdconvocatoria(Long idconvocatoria) {
        this.idconvocatoria = idconvocatoria;
    }

    public String getDescripcion_convocatoria() {
        return descripcion_convocatoria;
    }

    public void setDescripcion_convocatoria(String descripcion_convocatoria) {
        this.descripcion_convocatoria = descripcion_convocatoria;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

  
    
    
    
}
