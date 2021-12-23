package com.ProyectoTDSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTDSBackend.models.Asistencia;
import com.ProyectoTDSBackend.service.AsistenciaService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/asistenciaestututemp")
@CrossOrigin({ "*" })
public class AsistenciaController {
	@Autowired(required=true)
	AsistenciaService asistenciaService;
	
	/**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	@ApiOperation("Permite añadir una asignatura a un estudiante")
	@CrossOrigin({"*"})
    @PostMapping("/add-asistencias-Asistencia")
	ResponseEntity<GenericResponse<Object>> saveAsistencia(@RequestBody Asistencia asistencia,
			@RequestParam(value = "idestudiante")Long idestudiante,
			@RequestParam(value = "idcarrera")Long idcarrera,
			@RequestParam(value = "idtutoremp")Long idtutoremp) {
		return new ResponseEntity<GenericResponse<Object>>(asistenciaService.saveAsistencia(asistencia, idestudiante, idcarrera, idtutoremp), HttpStatus.OK);
	}
	
	@ApiOperation("Muestra un estudiante y la asistencia por id del estudiante")
	@CrossOrigin({"*"})
	@GetMapping("/getAsistenciaById-estudiante")
    public List<Asistencia> getBIdEstudiante(@RequestParam(value = "idestudiante") Long idestudiante) {
        return asistenciaService.getListarAsistenciaByIdestudiante(idestudiante);
    }
}
