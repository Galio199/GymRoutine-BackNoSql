package com.entornos.gymroutinenosql.service.impl;

import com.entornos.gymroutinenosql.model.Ejercicio;
import com.entornos.gymroutinenosql.repository.EjercicioRepository;
import com.entornos.gymroutinenosql.service.interfaces.IEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EjercicioService implements IEjercicioService {

    @Autowired
    EjercicioRepository ejercicioRepository;

    //Listar los ejercicios filtrando por dificultadEjercicio y/o tipoEjercicio, ordenando por dificultad el resultado
    @Override
    public List<Ejercicio> listarEjercicios(String dificultadEjercicio, String tipoEjercicio) {

        //Comprobar si ambos parametros son nulos
        if (dificultadEjercicio == null && tipoEjercicio == null) {
            return ejercicioRepository.findAllByOrderByOrdenDificultad();
        }

        //Comprobar si se filtra por ambos parametros
        if (dificultadEjercicio != null && tipoEjercicio != null) {
            return ejercicioRepository.findByDificultadEjercicioAndTipoEjercicioOrderByOrdenDificultad(dificultadEjercicio, tipoEjercicio);
        }

        //Comprobar si se filtra por dificultad de lo contrario filtrar por tipo
        if (dificultadEjercicio != null) {
            return ejercicioRepository.findByDificultadEjercicioOrderByOrdenDificultad(dificultadEjercicio);
        } else {
            return ejercicioRepository.findByTipoEjercicioOrderByOrdenDificultad(tipoEjercicio);
        }

    }
}
