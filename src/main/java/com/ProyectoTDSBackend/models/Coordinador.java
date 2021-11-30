package com.ProyectoTDSBackend.models;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "coordinador")
public class Coordinador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcoordinador", nullable = false)
	private Long idcoordinador;
	@Column(name = "estado", nullable = false)
	private String estado;
	
	
//	@JsonIgnore
//	  @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//	  @JoinColumn(name = "idpersona")
//		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	  private Persona persona;
//	
//	@JsonIgnore
//	  @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//	  @JoinColumn(name = "idcarrera")
//		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	  private Carrera carrera;

	

}
