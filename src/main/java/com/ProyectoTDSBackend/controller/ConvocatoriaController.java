/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.controller;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Actividad;
import com.ProyectoTDSBackend.models.Convocatoria;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/convocatoria")
@CrossOrigin({"*"})
public class ConvocatoriaController {
    
    @Autowired
    ConvocatoriaService actividadService;

//Listar todas las empresas
    @ApiOperation("Listado de las convocatorias")
    @CrossOrigin({"*"})
    @GetMapping("/convocatorias")
    public List<Convocatoria> getAllConvocatorias() {
        return actividadService.getlListaActividades();
    }
    
    
    // 
     @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Convocatoria convocatoria1) {
        if (StringUtils.isBlank(convocatoria1.getDescripcion_convocatoria())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(convocatoria1.getFecha_inicio().toString())) {
            return new ResponseEntity(new Mensaje("La fecha de inicio es obligatoria"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.isBlank(convocatoria1.getFecha_inicio().toString())) {
            return new ResponseEntity(new Mensaje("La fecha fin es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Convocatoria convocatoria = new Convocatoria(convocatoria1.getDescripcion_convocatoria(), convocatoria1.getFecha_inicio(), convocatoria1.getFecha_fin());
        actividadService.save(convocatoria);

        return new ResponseEntity(new Mensaje("Convocatoria creada"), HttpStatus.OK);
    }

}
