package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.Membresia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface MembresiaRepository extends MongoRepository<Membresia, String> {

    //Buscar las membresias que tiene un usuario
    List<Membresia> findByIdUsuario(String idUsuario);

}
