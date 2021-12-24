package com.ProyectoTDSBackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Asignatura;
import com.ProyectoTDSBackend.models.Documento;
import com.ProyectoTDSBackend.service.DocumentoService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/documento")
@CrossOrigin({ "*" })
public class DocumentoController {

	

	@Autowired
	DocumentoService documentoService;


	@ApiOperation("Muestra el listado de documentos")
	 @CrossOrigin({"*"})
	@GetMapping("/findAllDisponibles-Documentos")
	public List<Documento> getAllDocumentosDisponibles() {
		return documentoService.getAllDocumentos();
	}

	@ApiOperation("Permite añadir documentos")
	 @CrossOrigin({"*"})
	@PostMapping("/add-Documento")
	ResponseEntity<GenericResponse<Object>> saveDocumento(@RequestBody Documento documento) {
		return new ResponseEntity<GenericResponse<Object>>(documentoService.createDocumento(documento), HttpStatus.OK);
	}

	@ApiOperation("Actualizar campos de documento")
	 @CrossOrigin({"*"})
	@PostMapping("/put-documento")
	ResponseEntity<GenericResponse<Object>> putDocumento(@RequestParam(value = "iddocumento") Long iddocumento,
			@RequestParam(value = "nombreanexo") String nombreanexo,
			@RequestParam(value = "tipodocumento") String tipodocumento,
			@RequestParam(value = "enlacedocumento") String enlacedocumento) {
		return new ResponseEntity<GenericResponse<Object>>(
				documentoService.putDocumento(iddocumento, nombreanexo, tipodocumento, enlacedocumento),
				HttpStatus.OK);
	}
	
	 @CrossOrigin({"*"})
	    @GetMapping("/getById-documento")
	    public ResponseEntity<GenericResponse<Object>>getByIdDocumento(@RequestParam(value = "iddocumento") Long iddocumento) {
//	        return documentoService.getbyId(iddocumento);
	        return new ResponseEntity<GenericResponse<Object>>(documentoService.getbyId(iddocumento), HttpStatus.OK);
	    }


}
