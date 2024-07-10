package com.entornos.gymroutinenosql.controller;

import com.entornos.gymroutinenosql.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AutorizacionController {

    @Autowired
    IUsuarioService usuarioService;

    //Autentificar al usuario con el username y la contraseña
    @GetMapping("/")
    public ResponseEntity<Boolean> auth(@RequestParam(value = "username") String username,
                                        @RequestParam(value = "password") String password){
        return new ResponseEntity<>(usuarioService.validarUsuario(username, password), HttpStatus.OK);
    }

}
