package com.entornos.gymroutinenosql.controller;

import com.entornos.gymroutinenosql.model.TipoEjercicio;
import com.entornos.gymroutinenosql.service.interfaces.ITipoEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tipoEjercicio")
public class TipoEjercicioController {

    @Autowired
    ITipoEjercicioService tipoEjercicioService;

    //Listar los tipos de ejercicios
    @GetMapping("/list")
    public List<TipoEjercicio> listarTipos(){
        return tipoEjercicioService.listarTipos();
    }

    //Buscar un tipo por el id
    @GetMapping("/list/{id}")
    public TipoEjercicio buscarById(@PathVariable String id){
        return tipoEjercicioService.buscarTipoById(id);
    }
}
