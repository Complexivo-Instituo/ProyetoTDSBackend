/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.controller;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Convocatoria;
import com.ProyectoTDSBackend.models.Oficio;
import com.ProyectoTDSBackend.service.ConvocatoriaService;
import com.ProyectoTDSBackend.service.OficioService;
import com.ProyectoTDSBackend.util.GenericResponse;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/oficio")
@CrossOrigin({"*"})
public class OficioController {

    @Autowired
    OficioService oficioService;

//Listar todas las empresas
    @ApiOperation("Listado de los oficios")
    @CrossOrigin({"*"})
    @GetMapping("/oficios")
    public List<Oficio> getAllOficios() {
        return oficioService.getlListaOficios();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Oficio oficio1) {
        if (StringUtils.isBlank(oficio1.getFecha_inicio().toString())) {
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Oficio oficio = new Oficio(oficio1.getFecha_inicio());
        oficioService.save(oficio);

        return new ResponseEntity(new Mensaje("Convocatoria creada"), HttpStatus.OK);
    }

//
//    @ApiOperation("Eliminado logico del oficio")
//    @CrossOrigin({"*"})
//    @PatchMapping("/deleteOficio/{idoficio}")
//    public ResponseEntity<?> deleteOficio(@RequestParam(value = "idoficio") Long idoficio) {
//        Oficio oficio = oficioService.getOne(idoficio).get();
//        oficio.setEstado(0);
//        oficioServicei.save(oficio);
//        return new ResponseEntity(new Mensaje("Oficio eliminado"), HttpStatus.OK);
//    }
}
