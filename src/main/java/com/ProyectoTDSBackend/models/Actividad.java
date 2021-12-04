/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactividad", nullable = false)
    private Long idactividad;

    @Column(name = "horario", nullable = false)
    private String horario;

    @Column(name = "cronograma", nullable = false)
    private String cronograma;

    public Actividad() {
    }

    public Actividad(Long idactividad, String horario, String cronograma) {
        this.idactividad = idactividad;
        this.horario = horario;
        this.cronograma = cronograma;
    }

    public Actividad(String cronograma, String horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Long idactividad) {
        this.idactividad = idactividad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCronograma() {
        return cronograma;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }


	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public ResponsablePPP getResponsableppp() {
		return responsableppp;
	}

	public void setResponsableppp(ResponsablePPP responsableppp) {
		this.responsableppp = responsableppp;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idempresa")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Empresa empresa;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idresponsableppp")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private ResponsablePPP responsableppp;

}
