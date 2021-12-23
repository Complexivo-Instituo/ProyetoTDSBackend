package com.ProyectoTDSBackend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddocumento", nullable = false)
	private Long iddocumento;
	@Column(name = "nombreanexo", nullable = false)
	private String nombreanexo;
	@Column(name = "tipodocumento", nullable = false)
	private String tipodocumento;
	@Column(name = "enlacedocumento", nullable = false)
	private String enlacedocumento;

	public Documento() {
	}

	public Documento(Long iddocumento, String nombreanexo, String tipodocumento, String enlacedocumento) {
		super();
		this.iddocumento = iddocumento;
		this.nombreanexo = nombreanexo;
		this.tipodocumento = tipodocumento;
		this.enlacedocumento = enlacedocumento;
	}

	public Long getIddocumento() {
		return iddocumento;
	}

	public void setIddocumento(Long iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getNombreanexo() {
		return nombreanexo;
	}

	public void setNombreanexo(String nombreanexo) {
		this.nombreanexo = nombreanexo;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getEnlacedocumento() {
		return enlacedocumento;
	}

	public void setEnlacedocumento(String enlacedocumento) {
		this.enlacedocumento = enlacedocumento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
