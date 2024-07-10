package com.entornos.gymroutinenosql.controller;

import com.entornos.gymroutinenosql.model.Ejercicio;
import com.entornos.gymroutinenosql.service.interfaces.IEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    @Autowired
    IEjercicioService ejercicioService;

    //Listar los ejercicios filtrando por dificultad y/o tipo organizando por la dificultad
    @GetMapping("/list")
    public List<Ejercicio> listarEjercicios(
            @RequestParam(value = "tipoEjercicio", required = false) String tipoEjercicio,
            @RequestParam(value = "dificultadEjercicio", required = false) String dificultadEjercicio) {
        return ejercicioService.listarEjercicios(dificultadEjercicio, tipoEjercicio);
    }
}
