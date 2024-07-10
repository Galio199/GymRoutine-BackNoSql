package com.entornos.gymroutinenosql.service.interfaces;

import com.entornos.gymroutinenosql.DTO.UsuarioDTO;
import com.entornos.gymroutinenosql.model.Usuario;

public interface IUsuarioService {

    //Crear un nuevo usuario o guardar cambios en uno existente
    Usuario guardarUsuario(UsuarioDTO usuario);

    Boolean borrarUsuario(String id);

    //Buscar un usuario por el nombre de usuario
    Usuario buscarUsuarioByUsername(String username);

    //Verificar si se encontro un usuario con ese username y contraseña
    Boolean validarUsuario(String username, String password);
}
