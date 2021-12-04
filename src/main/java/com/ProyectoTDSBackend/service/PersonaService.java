package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.security.models.Persona;

public interface PersonaService {


	Persona getById(int idpersona);
	List<Persona> getAllPersonas();
}
