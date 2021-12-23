package com.ProyectoTDSBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoTDSBackend.models.Asistencia;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long>{
	
	List<Asistencia> findByestudiante(Long idestudiante);
	
}
