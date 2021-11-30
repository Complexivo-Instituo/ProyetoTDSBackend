package com.ProyectoTDSBackend.service;

import java.util.Date;
import java.util.List;

import com.ProyectoTDSBackend.models.Vinculacion;
import com.ProyectoTDSBackend.util.GenericResponse;


public interface VinculacionService {


	 GenericResponse<Object> createVinculacion(Vinculacion vinculacion);

	    GenericResponse<Object> putVinculacion(int idPersona, Long idvinculacion, String identificacion, String primernombre, String segundonombre,String primerapellido,String SegundoApellido, String email,int contacto);

	    List<Vinculacion> getAllVinculacion();

	    Vinculacion getById(Long idvinculacion);

	    GenericResponse<Object> eliminarvinculacionById(Long idvinculacion);

	    GenericResponse getConsutInfoWithPersona(String identificacion);

	    GenericResponse getConsultPersona(String identificacion);
}
