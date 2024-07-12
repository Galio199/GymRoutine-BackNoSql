package com.entornos.gymroutinenosql.controller;

import com.entornos.gymroutinenosql.DTO.UsuarioDTO;
import com.entornos.gymroutinenosql.model.Usuario;
import com.entornos.gymroutinenosql.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    //Guardar un nuevo usuario o actualizar uno existente
    @PostMapping("/")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody UsuarioDTO usuario) {
        return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.OK);
    }

}
