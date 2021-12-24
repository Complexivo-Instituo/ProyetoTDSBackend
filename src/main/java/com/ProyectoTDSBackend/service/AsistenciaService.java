package com.ProyectoTDSBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Asistencia;
import com.ProyectoTDSBackend.models.Carrera;
import com.ProyectoTDSBackend.models.Estudiante;
import com.ProyectoTDSBackend.models.TutorEmpresarial;
import com.ProyectoTDSBackend.repository.AsistenciaRepository;
import com.ProyectoTDSBackend.repository.CarreraRepository;
import com.ProyectoTDSBackend.repository.EstudianteRepository;
import com.ProyectoTDSBackend.repository.TutorEmpresarialRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;


@Service
public class AsistenciaService {
	
	
	@Autowired
	AsistenciaRepository asistenciaRepository;
	
	@Autowired
	EstudianteService estudianteService;
	
	@Autowired
	CarreraService carreraService;
	
	@Autowired
	TutorEmpresarialService tutorEmpresarialService;
	
	
	public List<Asistencia> getListarAsistenciaByIdestudiante(Long idestudiante) {
		Estudiante estudiante = estudianteService.getById(idestudiante);
		return asistenciaRepository.findByestudiante(estudiante);
	}
	
	public  GenericResponse<Object> saveAsistencia(Asistencia asistencia, Long idestudiante, Long idcarrera, Long idtutoremp) {
		GenericResponse<Object> response = new GenericResponse<>();
		List<Estudiante> estudiantes = estudianteService.getAllEstudiantes();
		List<TutorEmpresarial> empresariales = tutorEmpresarialService.getAllTutores();
		if (estudiantes.contains(estudianteService.getById(idestudiante)) != false) {
			if(carreraService.getbyId(idcarrera).getMessage() == "Exito") {
				if (empresariales.contains(tutorEmpresarialService.getById(idtutoremp)) != false) {
		    		asistencia.setEstudiante(estudianteService.getById(idestudiante));
		    		asistencia.setCarrera(carreraService.getbynombre(asistencia.getCarrera().getNombre()));
		    		asistencia.setTutorEmpresarial(tutorEmpresarialService.getById(idtutoremp));
		    		asistenciaRepository.save(asistencia);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("La asistencia se ha guardado con éxito");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
				} else {
					response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
					response.setObject("No existe la el tutor empresarial");
					response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
				}
			} else {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("No existe la carrera");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} else {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("No existe el estudiante");
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		}
		return response;
	}
}
