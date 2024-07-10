package com.entornos.gymroutinenosql.service.interfaces;

import com.entornos.gymroutinenosql.model.TipoEjercicio;

import java.util.List;

public interface ITipoEjercicioService {

    List<TipoEjercicio> listarTipos();

    TipoEjercicio buscarTipoById(String id);

}
