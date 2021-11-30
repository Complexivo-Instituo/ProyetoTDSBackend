/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.controller;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Actividad;
import com.ProyectoTDSBackend.models.Empresa;
import com.ProyectoTDSBackend.service.ActividadService;
import com.ProyectoTDSBackend.util.GenericResponse;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/actividad")
@CrossOrigin({"*"})
public class ActividadController {

    @Autowired
    ActividadService actividadService;

//Listar todas las empresas
    @ApiOperation("Listado de las actividades")
    @CrossOrigin({"*"})
    @GetMapping("/actividades")
    public List<Actividad> getActividades() {
        return actividadService.getlListaActividades();
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Actividad actividad1) {
        if (StringUtils.isBlank(actividad1.getHorario())) {
            return new ResponseEntity(new Mensaje("El horario es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(actividad1.getCronograma())) {
            return new ResponseEntity(new Mensaje("El cronograma es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Actividad actividad = new Actividad(actividad1.getCronograma(), actividad1.getHorario());
        actividadService.save(actividad);

        return new ResponseEntity(new Mensaje("Actividad creada"), HttpStatus.OK);
    }

    @ApiOperation("Actualizar campos de la actividad")
    @CrossOrigin
    @PostMapping("/actualizarActividad")
    ResponseEntity<GenericResponse<Object>> putEmpresa(
            @RequestParam(value = "idactividad") Long idactividad,
            @RequestParam(value = "horario") String horario,
            @RequestParam(value = "cronograma") String cronograma)
       {
        return new ResponseEntity<GenericResponse<Object>>(
                actividadService.putActividad(idactividad, horario, cronograma),
                HttpStatus.OK);
    }
}
