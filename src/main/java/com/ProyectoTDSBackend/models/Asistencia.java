package com.ProyectoTDSBackend.models;

import java.io.Serializable;
import java.util.Date;

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


@Entity
@Table(name = "asistenciaEstTutemp")
public class Asistencia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idasistencia", nullable = false)
	private Long idasistencia;
	
	@Column(name = "fechaActual", nullable = false)
	private Date fechaActual;
	
	@Column(name = "horaInicio", nullable = false)
	private Date horaInicio;
	
	@Column(name = "horaFin", nullable = false)
	private Date horaFin;
	
	@Column(name = "actividadRealizada", nullable = false)
	private String actividadRealizada;
	
	@Column(name = "numeroHoras", nullable = false)
	private int numeroHoras;

	public Long getIdasistencia() {
		return idasistencia;
	}

	public void setIdasistencia(Long idasistencia) {
		this.idasistencia = idasistencia;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public String getActividadRealizada() {
		return actividadRealizada;
	}

	public void setActividadRealizada(String actividadRealizada) {
		this.actividadRealizada = actividadRealizada;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public TutorEmpresarial getTutorEmpresarial() {
		return tutorEmpresarial;
	}

	public void setTutorEmpresarial(TutorEmpresarial tutorEmpresarial) {
		this.tutorEmpresarial = tutorEmpresarial;
	}



	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idcarrera")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Carrera carrera;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idestudiante")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Estudiante estudiante;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idtutoremp")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TutorEmpresarial tutorEmpresarial;
	
	
}
