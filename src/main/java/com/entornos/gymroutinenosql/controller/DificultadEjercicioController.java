package com.entornos.gymroutinenosql.controller;

import com.entornos.gymroutinenosql.model.DificultadEjercicio;
import com.entornos.gymroutinenosql.service.interfaces.IDificultadEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/dificultadEjercicios")
public class DificultadEjercicioController {

    @Autowired
    IDificultadEjercicioService dificultadEjercicioService;

    //Listar las dificultades
    @GetMapping("/list")
    public List<DificultadEjercicio> listarDificultades() {
        return dificultadEjercicioService.listarDificultades();
    }

    //Buscar una dificultad por id
    @GetMapping("/list/{id}")
    public DificultadEjercicio buscarById(@PathVariable String id) {
        return dificultadEjercicioService.buscarDificultadById(id);
    }
}
