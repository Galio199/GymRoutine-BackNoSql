package com.entornos.gymroutinenosql.service.interfaces;

import com.entornos.gymroutinenosql.model.DificultadEjercicio;

import java.util.List;

public interface IDificultadEjercicioService {

    List<DificultadEjercicio> listarDificultades();

    DificultadEjercicio buscarDificultadById(String id);

}
