package com.entornos.gymroutinenosql.service.impl;

import com.entornos.gymroutinenosql.model.TipoEjercicio;
import com.entornos.gymroutinenosql.repository.TipoEjercicioRepository;
import com.entornos.gymroutinenosql.service.interfaces.ITipoEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoEjercicioService implements ITipoEjercicioService {

    @Autowired
    TipoEjercicioRepository tipoEjercicioRepository;

    @Override
    public List<TipoEjercicio> listarTipos() {
        return tipoEjercicioRepository.findAll();
    }

    @Override
    public TipoEjercicio buscarTipoById(String id) {
        return tipoEjercicioRepository.findById(id).orElse(null);
    }
}
