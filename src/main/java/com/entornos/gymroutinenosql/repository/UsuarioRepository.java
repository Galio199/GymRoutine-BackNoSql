package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    //Buscar un usuario por el nombre de usuario
    Usuario findByUsername(String username);

    //Listar los usuarios por el nombre de usuario
    List<Usuario> findByUsernameContaining(String username);

}
