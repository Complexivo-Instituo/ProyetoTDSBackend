/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.service;

import com.ProyectoTDSBackend.models.Convocatoria;
import com.ProyectoTDSBackend.models.Oficio;
import com.ProyectoTDSBackend.repository.OficioRepository;
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
public class OficioService {

    @Autowired
    OficioRepository oficioRepository;

    public List<Oficio> getlListaOficios() {
        return oficioRepository.findAll();
    }

    public Optional<Oficio> getOne(Long id) {
        return oficioRepository.findById(id);
    }

    public void save(Oficio oficio) {
        oficioRepository.save(oficio);
    }
    
     public GenericResponse<Object> putOficio(Long idoficio, Date fecha_inicio) {
        GenericResponse<Object> response = new GenericResponse<>();
        Oficio oficio = oficioRepository.findById(idoficio).get();
        if (oficio.getIdoficio()!= null) {
            oficio.setFecha_inicio(fecha_inicio);
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

    public Optional<Oficio> getOne(long id) {
        return oficioRepository.findById(id);
    }
}
