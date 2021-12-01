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
public class VinculacionImpl implements VinculacionService {

	@Autowired
	VinculacionRepository vinculacionRepository;
	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	VinculacionService vinculacionService;

	@Transactional
	@Override
	public GenericResponse<Object> createVinculacion(Vinculacion vinculacion) {
		GenericResponse<Object> response = new GenericResponse<>();
		try {
			if (personaRepository.findByIdentificacion(vinculacion.getPersona().getIdentificacion()) != null) {
				vinculacion.setPersona(
						personaRepository.findByIdentificacion(vinculacion.getPersona().getIdentificacion()));
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

	@Transactional
	@Override
	public GenericResponse<Object> putVinculacion(int idpersona, Long idvinculacion, String identificacion,
			String primernombre, String segundonombre, String primerapellido, String segundoapellido, String email) {
		GenericResponse<Object> response = new GenericResponse<>();

		try {
			if (vinculacionRepository.findById(idvinculacion).isEmpty() == false) {
				Vinculacion vinculacion = vinculacionRepository.findById(idvinculacion).get();
				if (personaRepository.findById(idpersona).isEmpty() == true) {
					response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
					response.setObject("No se puede actualizar la vinculacion porque no se encontro esta persona");
					response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
				} else {
					vinculacion.setPersona(personaRepository.findById(idpersona).get());
					vinculacion.getPersona().setPrimernombre(primernombre);
					vinculacion.getPersona().setPrimernombre(primernombre);
					vinculacion.getPersona().setSegundonombre(segundonombre);
					vinculacion.getPersona().setPrimerapellido(primerapellido);
					vinculacion.getPersona().setSegundoapellido(segundoapellido);
					vinculacion.getPersona().setEmail(email);
					vinculacionRepository.saveAndFlush(vinculacion);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("Usuario Editado");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
				}
			} else {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("Usuario no encontrado");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("ERROR " + e);
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		}
		return response;
	}

	@Transactional
	@Override
	public Vinculacion getById(Long idvinculacion) {
		return vinculacionRepository.findByidvinculacion(idvinculacion);
	}

	@Transactional
	@Override
	public List<Vinculacion> getAllVinculaciones() {
		return vinculacionRepository.findAll();
	}

	@Override
	public List<Vinculacion> getByrolvinculacion(String rolvinculacion) {
		return vinculacionRepository.findByrolvinculacion(rolvinculacion);
	}

}
