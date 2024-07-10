package com.entornos.gymroutinenosql.service.impl;

import com.entornos.gymroutinenosql.model.DificultadEjercicio;
import com.entornos.gymroutinenosql.repository.DificultadEjercicioRepository;
import com.entornos.gymroutinenosql.service.interfaces.IDificultadEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DificultadEjercicioService implements IDificultadEjercicioService {

    @Autowired
    DificultadEjercicioRepository dificultadEjercicioRepository;

    @Override
    public List<DificultadEjercicio> listarDificultades() {
        return dificultadEjercicioRepository.findAll();
    }

    @Override
    public DificultadEjercicio buscarDificultadById(String id) {
        return dificultadEjercicioRepository.findById(id).orElse(null);
    }
}
