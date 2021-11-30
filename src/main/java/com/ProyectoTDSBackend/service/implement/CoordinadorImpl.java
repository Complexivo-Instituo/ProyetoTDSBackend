package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Coordinador;
import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.service.CoordinadorService;
import com.ProyectoTDSBackend.util.GenericResponse;

@Service
public class CoordinadorImpl implements CoordinadorService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	CoordinadorService coordinadorService;
	
	@Override
	public GenericResponse<Object> createCoordinador(Coordinador coordinador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericResponse<Object> putCoordinador(int idPersona, Long idcoordinador, String identificacion,
			String primernombre, String segundonombre, String primerapellido, String SegundoApellido, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coordinador> getAllCoordinadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coordinador getById(Long idcoordinador) {
		// TODO Auto-generated method stub
		return coordinadorService.getById(idcoordinador);
	}

}
