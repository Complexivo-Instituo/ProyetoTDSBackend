package com.ProyectoTDSBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Documento;
import com.ProyectoTDSBackend.repository.DocumentoRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class DocumentoService {
	
	@Autowired
	DocumentoRepository documentoRepository;
	
	public GenericResponse getbyId(Long iddocumento) {
		GenericResponse<Object> response = new GenericResponse<>();
		   try {
	            if (documentoRepository.findByiddocumento(iddocumento) != null) {
	                Documento documento = documentoRepository.findByiddocumento(iddocumento);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject(documento);
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            } else {
	                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                response.setObject("Estado no encontrado");
	                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            }
	        } catch (Exception e) {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("ERROR " + e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	}
	
	
	
	    public GenericResponse<Object> createDocumento(Documento documento) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        try {
//	            if (documentoRepository.findBynombreanexo(documento.getNombreanexo().toUpperCase()) != null){
	                documento.setNombreanexo(documento.getNombreanexo().toUpperCase());
	                documento.setTipodocumento(documento.getTipodocumento().toUpperCase());
	                documento.setEnlacedocumento(documento.getEnlacedocumento());
	                documentoRepository.save(documento);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject("Documento :"+documento.getIddocumento()+" creado exitosamente como Documento");
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
//	            } else {
//	                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
//	                response.setObject("Nombre de Documento en Documento duplicado");
//	                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
//	            }
	        }catch (Exception e){
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error: "+e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	    }
	    
	    public GenericResponse<Object> putDocumento(Long iddocumento, String nombreanexo,String tipodocumento,String enlacedocumento) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        Documento documento = documentoRepository.findByiddocumento(iddocumento);
	        if (documento.getIddocumento() != null ) {
	            documento.setNombreanexo(nombreanexo.toUpperCase());
	            documento.setTipodocumento(tipodocumento.toUpperCase());
	            documento.setEnlacedocumento(enlacedocumento);
	            documentoRepository.save(documento);
	            response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	            response.setObject("Actualizado correctamente");
	            response.setStatus(ParametersApp.SUCCESSFUL.value());
	        } else {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error al actualizar");
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	    }
	    
	    public Documento getbynombreanexo(String nombreanexo) {
			return documentoRepository.findBynombreanexo(nombreanexo);
		}
	    public List<Documento> getAllDocumentos() {
	        return documentoRepository.findAll();
	    }
	    
	    public boolean existsBynombre_anexo(String nombreanexo) {
	        return documentoRepository.existsBynombreanexo(nombreanexo);
	    }

}
