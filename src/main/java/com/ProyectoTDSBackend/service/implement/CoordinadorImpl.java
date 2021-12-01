package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Coordinador;
import com.ProyectoTDSBackend.models.Vinculacion;
import com.ProyectoTDSBackend.repository.CarreraRepository;
import com.ProyectoTDSBackend.repository.CoordinadorRepository;
import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.service.CoordinadorService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class CoordinadorImpl implements CoordinadorService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	CarreraRepository carreraRepository;
	
	@Autowired
	CoordinadorService coordinadorService;
	
	@Autowired
	CoordinadorRepository coordinadorRepository;
	
	@Transactional
	@Override
	public GenericResponse<Object> createCoordinador(Coordinador coordinador) {
		GenericResponse<Object> response = new GenericResponse<>();
		try {
			if (personaRepository.findByIdentificacion(coordinador.getPersona().getIdentificacion()) != null ) {
				//if(carreraRepository.findBynombre(coordinador.getCarrera().getNombre())!=null) {
					coordinador.setCarrera(carreraRepository.findByidcarrera(coordinador.getCarrera().getIdcarrera()));
//					coordinador.setPersona(personaRepository.findByIdentificacion(coordinador.getPersona().getIdentificacion()));
					
					coordinador.setEstado(1);
					coordinadorRepository.save(coordinador);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("Coordinador creado");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
					
//				}else {
//				}
				
			} else {
				coordinadorRepository.save(coordinador);
				response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
				response.setObject("Coordinador creado");
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
	public GenericResponse<Object> putCoordinador(int idpersona, Long idcoordinador, String identificacion,
			String primernombre, String segundonombre, String primerapellido, String segundoapellido, String email,int contacto) {
GenericResponse<Object> response = new GenericResponse<>();
		
		try {
            if (coordinadorRepository.findById(idcoordinador).isEmpty() == false) {
                Coordinador coordinador = coordinadorRepository.findById(idcoordinador).get();
                if (personaRepository.findById(idpersona).isEmpty() == true) {
                    response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
                    response.setObject("No se puede actualizar el coordinador porque no se encontro esta persona");
                    response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
                } else {
                    coordinador.setPersona(personaRepository.findByidpersona(idpersona));
                    coordinador.getPersona().setPrimernombre(primernombre);
                    coordinador.getPersona().setPrimernombre(primernombre);
                    coordinador.getPersona().setSegundonombre(segundonombre);
                    coordinador.getPersona().setPrimerapellido(primerapellido);
                    coordinador.getPersona().setSegundoapellido(segundoapellido);
                    coordinador.getPersona().setEmail(email);
                    coordinador.getPersona().setContacto(contacto);
                    coordinadorRepository.saveAndFlush(coordinador);
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

	@Override
	public List<Coordinador> getAllCoordinadores() {
		return coordinadorService.getAllCoordinadores();
	}

	@Override
	public Coordinador getById(Long idcoordinador) {
		return coordinadorService.getById(idcoordinador);
	}

}
