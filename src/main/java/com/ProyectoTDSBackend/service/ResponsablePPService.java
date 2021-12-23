package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.models.ResponsablePPP;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface ResponsablePPService {
	
	GenericResponse<Object> createResponsablePPP(ResponsablePPP responsable,Long idcarrera,int idpersona);

	List<ResponsablePPP> getAllResponsablesPPP();
	
	GenericResponse<Object> updateResponsablePPP(ResponsablePPP responsable,Long idcarrera,int idpersona);
	
	void deleteResponsablePPP(Long idresponsableppp);
	
	ResponsablePPP getById(Long idresponsableppp);

}
