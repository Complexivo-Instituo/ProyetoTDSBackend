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
@Table(name = "vinculacion")
public class Vinculacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvinculacion", nullable = false)
	private Long idvinculacion;
	@Column(name = "rolvinculacion", nullable = false)
	private String rolvinculacion;
//	@JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "idpersona")
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Persona persona;

}
