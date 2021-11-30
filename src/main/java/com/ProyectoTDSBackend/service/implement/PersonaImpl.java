package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.security.models.Persona;
import com.ProyectoTDSBackend.service.PersonaService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

public class PersonaImpl implements PersonaService{
	
	@Autowired
	PersonaRepository personaRepository;
	
	public GenericResponse getbyId(int idpersona) {
		GenericResponse<Object> response = new GenericResponse<>();
		   try {
	            if (personaRepository.findByidpersona(idpersona) != null) {
	                Persona persona = personaRepository.findByidpersona(idpersona);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject(persona);
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            } else {
	                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                response.setObject("Persona no encontrada");
	                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            }
	        } catch (Exception e) {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("ERROR " + e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	}
	
	
	    public List<Persona> getAllPersonas() {
	        return personaRepository.findAll();
	    }

		@Override
		public GenericResponse<Object> createPersona(Persona persona) {
			  GenericResponse<Object> response = new GenericResponse<>();
		        try {
		            if (personaRepository.findByIdentificacion(persona.getIdentificacion()) == null){
		            	persona.setPrimernombre(persona.getPrimernombre().toUpperCase());
		            	persona.setSegundonombre(persona.getSegundonombre().toUpperCase());
		            	persona.setPrimerapellido(persona.getPrimerapellido().toUpperCase());
		            	persona.setSegundoapellido(persona.getSegundoapellido().toUpperCase());
		            	persona.setEmail(persona.getEmail());
//		            	persona.setContacto(persona.getContacto());
		                persona.setEstado(1);
		                personaRepository.save(persona);
		                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
		                response.setObject("Persona :"+persona.getPrimernombre()+" "+persona.getPrimerapellido()+" creado exitosamente como Carrera");
		                response.setStatus(ParametersApp.SUCCESSFUL.value());
		            } else {
		                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
		                response.setObject("Nombre Persona en Persona duplicado");
		                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		            }
		        }catch (Exception e){
		            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
		            response.setObject("Error: "+e);
		            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		        }
		        return response;
		}



		@Override
		public GenericResponse<Object> putPersona(int idpersona, String identificacion, String primernombre,
				String segundonombre, String primerapellido, String SegundoApellido, String email, int contacto) {
		    GenericResponse<Object> response = new GenericResponse<>();
	        Persona persona =personaRepository.findByidpersona(idpersona);
	        if (persona.getIdentificacion() != null ) {
            	persona.setPrimernombre(persona.getPrimernombre().toUpperCase());
            	persona.setSegundonombre(persona.getSegundonombre().toUpperCase());
            	persona.setPrimerapellido(persona.getPrimerapellido().toUpperCase());
            	persona.setSegundoapellido(persona.getSegundoapellido().toUpperCase());
            	persona.setEmail(persona.getEmail());
//            	persona.setContacto(persona.getContacto());
                persona.setEstado(1);
	            personaRepository.save(persona);
	            response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	            response.setObject("Actualizado correctamente");
	            response.setStatus(ParametersApp.SUCCESSFUL.value());
	        } else {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error al actualizar");
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
		}
	
}
