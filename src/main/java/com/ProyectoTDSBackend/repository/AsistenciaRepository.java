package com.ProyectoTDSBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoTDSBackend.models.Asistencia;
import com.ProyectoTDSBackend.models.Estudiante;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long>{
	
	List<Asistencia> findByestudiante(Estudiante idestudiante);
	
}
