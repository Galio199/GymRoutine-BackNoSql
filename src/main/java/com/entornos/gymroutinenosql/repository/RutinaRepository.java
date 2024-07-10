package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.Rutina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RutinaRepository extends MongoRepository<Rutina, String> {

    //Listar todas las rutinas ordenadas por dificultad
    List<Rutina> findAllByOrderByOrdenDificultad();

    //Listar los ejercicios filtrados por el tipo o la dificultad
    @Query("{ $and: [ { $or: [ { 'tipoRutina': { $elemMatch: { $in: ?0 } } }, { ?0: null } ] }, " +
            "{ $or: [ { 'dificultad': ?1 }, { ?1: null } ] } ] }")
    List<Rutina>findByTipoRutinaAndDificultadRutina(String tipoRutina, String dificultadRutina);

}
