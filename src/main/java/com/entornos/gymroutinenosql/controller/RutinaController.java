package com.entornos.gymroutinenosql.controller;

import com.entornos.gymroutinenosql.model.Rutina;
import com.entornos.gymroutinenosql.service.interfaces.IRutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/rutinas")
public class RutinaController {

    @Autowired
    IRutinaService rutinaService;

    //Listar las rutinas por el tipo y/o dificultad ordenadas por dificultad
    @GetMapping("/list")
    public List<Rutina> listarRutinas(
            @RequestParam(value = "tipoRutina", required = false) String tipoRutina,
            @RequestParam(value = "dificultadRutina", required = false) String dificultadRutina) {
        return rutinaService.listarRutinas(tipoRutina, dificultadRutina);
    }

    //Listar las rutinas del usuario por el id del usuario loggeado
    @GetMapping("/listByIdUsuario/{idUsuario}")
    public List<Rutina> listarRutinasByIdUsuario(@PathVariable String idUsuario){
        return rutinaService.listarRutinasByIdUsuario(idUsuario);
    }

    //Listar rutinas de otros usuario por el username
    @GetMapping("/listByUsername/{username}")
    public List<Rutina> listarRutinasByUsername(@PathVariable String username){
        return rutinaService.listarRutinasByUsername(username);
    }

    //Guardar una rutina o actualizar una existente
    @PostMapping("/")
    public ResponseEntity<Object> guardarRutina(@RequestBody Rutina rutina){
        return new ResponseEntity<>(rutinaService.guardarRutina(rutina), HttpStatus.OK);
    }

    //Eliminar una rutina por el id de la rutina
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Rutina> eliminarRutina(@PathVariable String id){
        Rutina obj = rutinaService.buscarRutina(id);
        if (obj != null) {
            rutinaService.borrarRutina(id);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
