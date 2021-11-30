package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.security.models.Persona;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface PersonaService {

	GenericResponse<Object> createPersona(Persona persona);

	GenericResponse<Object> putPersona(int idpersona, String identificacion, String primernombre, String segundonombre,
			String primerapellido, String SegundoApellido, String email, int contacto);

	List<Persona> getAllPersonas();
}
