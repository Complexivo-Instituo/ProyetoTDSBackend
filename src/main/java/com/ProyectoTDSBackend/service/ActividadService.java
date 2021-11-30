/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.service;

import java.util.List;
import java.util.Optional;

import com.ProyectoTDSBackend.models.Actividad;
import com.ProyectoTDSBackend.repository.ActividadRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class ActividadService {

    @Autowired
    ActividadRepository actividadRepository;

    public List<Actividad> getlListaActividades() {
        return actividadRepository.findAll();
    }

    public Optional<Actividad> getOne(Long id) {
        return actividadRepository.findById(id);
    }

    public void save(Actividad actividad) {
        actividadRepository.save(actividad);
    }

    public void delete(Long id) {
        actividadRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return actividadRepository.existsById(id);
    }

    public GenericResponse<Object> putActividad(Long idactividad, String horario, String cronograma) {
        GenericResponse<Object> response = new GenericResponse<>();
        Actividad actividad = actividadRepository.findById(idactividad).get();
        if (actividad.getIdactividad() != null) {
            actividad.setHorario(horario.toUpperCase());
            actividad.setCronograma(cronograma.toUpperCase());
            actividadRepository.save(actividad);
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
