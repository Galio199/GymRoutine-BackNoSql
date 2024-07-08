package com.entornos.gymroutinenosql.service.impl;

import com.entornos.gymroutinenosql.model.Usuario;
import com.entornos.gymroutinenosql.repository.UsuarioRepository;
import com.entornos.gymroutinenosql.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
