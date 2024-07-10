package com.entornos.gymroutinenosql.service.impl;

import com.entornos.gymroutinenosql.model.Ejercicio;
import com.entornos.gymroutinenosql.repository.EjercicioRepository;
import com.entornos.gymroutinenosql.service.interfaces.IEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EjercicioService implements IEjercicioService {

    @Autowired
    EjercicioRepository ejercicioRepository;

    //Listar los ejercicios filtrando por dificultadEjercicio y/o tipoEjercicio, ordenando por dificultad el resultado
    @Override
    public List<Ejercicio> listarEjercicios(String dificultadEjercicio, String tipoEjercicio) {
        return ejercicioRepository.findByDificultadEjercicioAndTipoEjercicioOrderByOrdenDificultad(dificultadEjercicio, tipoEjercicio);
    }
}
