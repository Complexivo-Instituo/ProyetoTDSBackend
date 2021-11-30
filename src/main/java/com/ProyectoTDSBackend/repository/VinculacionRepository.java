package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoTDSBackend.models.Vinculacion;


public interface VinculacionRepository extends JpaRepository<Vinculacion, Long> {

	
	Vinculacion findByPersonaIdentificacion(String identificacion);
}
