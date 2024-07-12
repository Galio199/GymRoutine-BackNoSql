package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.Rutina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RutinaRepository extends MongoRepository<Rutina, String> {
    /*
    //Listar todas las rutinas ordenadas por dificultad
    List<Rutina> findAllByOrderByOrdenDificultad();
     */

    //Listar las rutinas publicadas filtradas por el tipo y/o la dificultad ordenadas por dificultad
    @Query("{ $and: [ { $or: [ { 'tipoRutina': { $elemMatch: { $in: ?0 } } }, { ?0: null } ] }, " +
            "{ $or: [ { 'dificultad': ?1 }, { ?1: null } ] } ] }")
    List<Rutina>findByTipoRutinaAndDificultadRutinaAndPublicadaOrderByOrdenDificultad(String tipoRutina, String dificultadRutina, boolean publicada);

    //Listar las rutinas publicadas que ha creado un usuario por el username
    List<Rutina> findByUsernameAndPublicada(String username, boolean publicada);

    //Listar las rutinas que ha creado un usuario por el id del usuario
    List<Rutina> findByIdUsuario(String idUsuario);

}
