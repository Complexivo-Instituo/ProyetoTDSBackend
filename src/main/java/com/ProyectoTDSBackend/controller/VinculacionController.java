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

import com.ProyectoTDSBackend.models.Vinculacion;
import com.ProyectoTDSBackend.service.VinculacionService;
import com.ProyectoTDSBackend.util.GenericResponse;


@RestController
@RequestMapping("/vinculacion")
@CrossOrigin({ "*" })
public class VinculacionController {
	
	@Autowired
	VinculacionService vinculacionService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	 @CrossOrigin
	    @PostMapping("/add-vinculacion")
	    ResponseEntity<GenericResponse<Object>> saveVinculacion(@RequestBody Vinculacion vinculacion) {
	        return new ResponseEntity<GenericResponse<Object>>(vinculacionService.createVinculacion(vinculacion), HttpStatus.OK);
	    }

	 
	   @CrossOrigin
	    @GetMapping("/findAll-vinculacion")
	    public List<Vinculacion> getAllArrendatario() {
	        return vinculacionService.getAllVinculacion();
	    }
	   
	    /**
	     * CONSTRUCCION DEL METODO PUT PARA ACTUALIZAR DATOS DEL ARRENDATARIO
	     */
	    @CrossOrigin
	    @PostMapping("/put-vinculacion")
	    ResponseEntity<GenericResponse<Object>> putArrendatario(
	    		 @RequestParam(value = "idpersona") int idpersona,
	    		@RequestParam(value = "idvinculacion") Long idvinculacion,
	            @RequestParam(value = "identificacion") String identificacion,
	            @RequestParam(value = "primernombre") String primernombre,
	            @RequestParam(value = "primerapellido") String primerapellido,
	            @RequestParam(value = "segundonombre") String segundonombre,
	            @RequestParam(value = "segundonombre") String segundoapellido,
	            @RequestParam(value = "contacto") int contacto,
	            @RequestParam(value = "email") String email
	    ) {
	        return new ResponseEntity<GenericResponse<Object>>(vinculacionService.putVinculacion(idpersona, idvinculacion, identificacion, primernombre, segundonombre, primerapellido, segundoapellido, email, contacto), HttpStatus.OK);
	    }
	    @GetMapping("/getById-vinculacion")
	    public Vinculacion getByIdVinculacion(@RequestParam(value = "idvinculacion") Long idvinculacion) {
	        return vinculacionService.getById(idvinculacion);
	    }

}