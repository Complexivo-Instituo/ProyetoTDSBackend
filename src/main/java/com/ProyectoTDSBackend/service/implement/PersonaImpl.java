package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.security.models.Persona;
import com.ProyectoTDSBackend.service.PersonaService;
@Service
public class PersonaImpl implements PersonaService{
	
	@Autowired
	PersonaRepository personaRepository;
	
	
	    public List<Persona> getAllPersonas() {
	        return personaRepository.findAll();
	    }


		@Override
		public Persona getById(int idpersona) {
			 Persona persona = personaRepository.findByidpersona(idpersona);
		        return persona;
		}

	
}
