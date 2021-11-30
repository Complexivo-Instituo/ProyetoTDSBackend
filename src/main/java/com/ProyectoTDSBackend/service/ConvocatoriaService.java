/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.service;

import com.ProyectoTDSBackend.models.Actividad;
import com.ProyectoTDSBackend.models.Convocatoria;
import com.ProyectoTDSBackend.repository.ConvocatoriaRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class ConvocatoriaService {

    @Autowired
    ConvocatoriaRepository conovocatoriaRepository;

    public List<Convocatoria> getlListaActividades() {
        return conovocatoriaRepository.findAll();
    }

    public Optional<Convocatoria> getOne(Long id) {
        return conovocatoriaRepository.findById(id);
    }

    public void save(Convocatoria producto) {
        conovocatoriaRepository.save(producto);
    }

    public boolean existsById(Long id) {
        return conovocatoriaRepository.existsById(id);
    }

    public GenericResponse<Object> putActividad(Long idconvocatoria, String descripcion, Date fecha_inicio, Date fecha_fin) {
        GenericResponse<Object> response = new GenericResponse<>();
        Convocatoria convocatoria = conovocatoriaRepository.findById(idconvocatoria).get();
        if (convocatoria.getIdconvocatoria()!= null) {
            convocatoria.setDescripcion_convocatoria(descripcion.toUpperCase());
            convocatoria.setFecha_inicio(fecha_inicio);
             convocatoria.setFecha_fin(fecha_fin);
            conovocatoriaRepository.save(convocatoria);
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
}
