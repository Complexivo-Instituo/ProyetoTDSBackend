package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ProyectoTDSBackend.models.Vinculacion;
import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.repository.VinculacionRepository;
import com.ProyectoTDSBackend.service.VinculacionService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class VinculacionImpl implements VinculacionService{
	
	@Autowired
    VinculacionRepository vinculacionRepository; 
	@Autowired
    PersonaRepository personaRepository; 
	
	@Transactional
	@Override
	public GenericResponse<Object> createVinculacion(Vinculacion vinculacion) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        try {
	            if (personaRepository.findByIdentificacion(vinculacion.getPersona().getIdentificacion()) != null) {
	                vinculacion.setPersona(personaRepository.findByIdentificacion(vinculacion.getPersona().getIdentificacion()));
	                vinculacionRepository.save(vinculacion);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject("Vinculacion creada");
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            } else {
	                vinculacionRepository.save(vinculacion);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject("Vinculacion creada");
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            }
	        } catch (Exception e) {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error: " + e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	}

	@Override
	public GenericResponse<Object> putVinculacion(int idPersona, Long idvinculacion, String identificacion,
			String primernombre, String segundonombre, String primerapellido, String segundoapellido, String email,
			int contacto) {
		  GenericResponse<Object> response = new GenericResponse<>();
	        Vinculacion vinculacion = vinculacionRepository.findById(idvinculacion).get();
	        if (vinculacion.getPersona().getIdpersona() == idPersona) {
	            vinculacion.getPersona().setPrimernombre(primernombre);
	            vinculacion.getPersona().setSegundonombre(segundonombre);
	            vinculacion.getPersona().setPrimerapellido(primerapellido);
	            vinculacion.getPersona().setSegundoapellido(segundoapellido);
	            vinculacion.getPersona().setEmail(email);
	            vinculacionRepository.saveAndFlush(vinculacion);
	            response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	            response.setObject("Arrendatario Actualizado");
	            response.setStatus(ParametersApp.SUCCESSFUL.value());
	        }
	        response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	        response.setObject("Error");
	        response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        return response;
	}

	@Override
	public List<Vinculacion> getAllVinculacion() {
		return vinculacionRepository.findAll();
		
	}

	@Override
	public Vinculacion getById(Long idvinculacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericResponse<Object> eliminarvinculacionById(Long idvinculacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericResponse getConsutInfoWithPersona(String identificacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericResponse getConsultPersona(String identificacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
