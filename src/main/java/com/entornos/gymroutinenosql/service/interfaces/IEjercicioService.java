package com.entornos.gymroutinenosql.service.interfaces;

import com.entornos.gymroutinenosql.model.Ejercicio;

import java.util.List;

public interface IEjercicioService {

    //Listar los ejercicios filtrando por dificultadEjercicio y/o tipoEjercicio, ordenando por dificultad el resultado
    List<Ejercicio> listarEjercicios(String dificultadEjercicio, String tipoEjercicio);
}
