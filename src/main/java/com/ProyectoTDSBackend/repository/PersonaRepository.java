package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.security.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	Persona findByIdentificacion(String identificacion);
	
	Persona findByidpersona(int idpersona);
	
	
	

}
