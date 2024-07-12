package com.entornos.gymroutinenosql.service.impl;

import com.entornos.gymroutinenosql.DTO.UsuarioDTO;
import com.entornos.gymroutinenosql.model.Autorizacion;
import com.entornos.gymroutinenosql.model.Usuario;
import com.entornos.gymroutinenosql.repository.AutorizacionRepository;
import com.entornos.gymroutinenosql.repository.UsuarioRepository;
import com.entornos.gymroutinenosql.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    AutorizacionRepository autorizacionRepository;

    //Crear un nuevo usuario o guardar cambios en uno existente
    @Override
    public Usuario guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        Autorizacion autorizacion = new Autorizacion();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setFechaCreacion(LocalDateTime.now());
        var usuarioSave = usuarioRepository.save(usuario);
        autorizacion.setIdUsuario(usuarioSave.getId());
        autorizacion.setClave(usuarioDTO.getClave());
        autorizacion.setFechaInicio(LocalDateTime.now());
        autorizacionRepository.save(autorizacion);
        return usuarioSave;
    }

    @Override
    public Boolean borrarUsuario(String id) {
        usuarioRepository.deleteById(id);
        return true;
    }

    //Buscar un usuario por el nombre de usuario
    @Override
    public List<Usuario> buscarUsuarioByUsername(String username) {
        return usuarioRepository.findByUsernameContaining(username);
    }

    //Verificar si se encontro un usuario con ese username y contraseña
    @Override
    public Boolean validarUsuario(String username, String password) {
        String idUsuario = usuarioRepository.findByUsername(username).getId();
        if (idUsuario == null) {
            throw new RuntimeException("Usuario o contraseña erronea");
        }
        var auth = autorizacionRepository.findByIdUsuarioAndClave(idUsuario, password);
        if (auth == null) {
            throw new RuntimeException("Usuario o contraseña erronea");
        }
        return true;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setAutorizacionRepository(AutorizacionRepository autorizacionRepository) {
        this.autorizacionRepository = autorizacionRepository;
    }
}
