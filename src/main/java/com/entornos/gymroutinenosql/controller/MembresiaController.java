package com.entornos.gymroutinenosql.controller;

import com.entornos.gymroutinenosql.model.Membresia;
import com.entornos.gymroutinenosql.service.interfaces.IMembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/membresia")
public class MembresiaController {

    @Autowired
    IMembresiaService membresiaService;

    //Guardar una nueva membresia o actualizar una existente
    @PostMapping("/")
    public ResponseEntity<Membresia> guardarMembresia(@RequestBody Membresia membresia){
        Membresia obj = membresiaService.guardarMembresia(membresia);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //Listar las membresias de un usuario por el id del usuario
    @GetMapping("/list/{idUser}")
    public List<Membresia> listarMembresiasByIdUsario(@PathVariable String idUser){
        return membresiaService.listarMembresiasByIdUsuario(idUser);
    }

    //Eliminar una membresia por el id de la membresia
    @DeleteMapping("/{id}")
    public ResponseEntity<Membresia> eliminarMembresia(@PathVariable String id){
        Membresia obj = membresiaService.buscarMembresia(id);
        if(obj != null){
            membresiaService.borrarMembresia(id);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
