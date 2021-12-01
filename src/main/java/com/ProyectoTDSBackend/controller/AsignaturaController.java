/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.controller;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Asignatura;
import com.ProyectoTDSBackend.models.Convocatoria;
import com.ProyectoTDSBackend.service.AsignaturaService;
import com.ProyectoTDSBackend.service.ConvocatoriaService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author LENOVO
 */
public class AsignaturaController {

    @Autowired
    AsignaturaService asignaturaService;

//Listar todas las empresas
    @ApiOperation("Listado de las asignaturas")
    @CrossOrigin({"*"})
    @GetMapping("/asignaturas")
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaService.getlListaAsignaturas();
    }

    // 
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Asignatura asignatura1) {
        if (StringUtils.isBlank(asignatura1.getNombreasignatura())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Asignatura asignatura = new Asignatura(asignatura1.getNombreasignatura(), asignatura1.getPromedio());

        asignaturaService.save(asignatura);

        return new ResponseEntity(new Mensaje("Convocatoria creada"), HttpStatus.OK);
    }
}
