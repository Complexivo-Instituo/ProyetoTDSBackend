/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.service;

import com.ProyectoTDSBackend.models.Asignatura;
import com.ProyectoTDSBackend.repository.AsignaturaRepository;
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
public class AsignaturaService {

    @Autowired
    AsignaturaRepository asignaturaRepository;

    
    public List<Asignatura> getlListaAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> getOne(Long id) {
        return asignaturaRepository.findById(id);
    }

    public void save(Asignatura producto) {
        asignaturaRepository.save(producto);
    }

    public boolean existsById(Long id) {
        return asignaturaRepository.existsById(id);
    }

    public GenericResponse<Object> putAsignatura(Long idasignatura, String nombreasignatura, Float promedio) {
        GenericResponse<Object> response = new GenericResponse<>();
        Asignatura asignatura = asignaturaRepository.findById(idasignatura).get();
        if (asignatura.getIdasiganatura()!= null) {
            asignatura.setNombreasignatura(nombreasignatura.toUpperCase());
            asignatura.setPromedio(promedio);
            asignaturaRepository.save(asignatura);
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

    public Optional<Asignatura> getOne(long id) {
        return asignaturaRepository.findById(id);
    }
}
