package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.Autorizacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AutorizacionRepository extends MongoRepository<Autorizacion, String> {

    //Buscar la autorizacion con el usuario y la clave
    Autorizacion findByUsuarioUsernameAndClave(String username, String clave);

}
