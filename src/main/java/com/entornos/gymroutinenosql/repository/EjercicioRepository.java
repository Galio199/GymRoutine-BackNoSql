package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.Ejercicio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface EjercicioRepository extends MongoRepository<Ejercicio, String> {
    /*
    //Listar los ejercicios ordenados por dificultad
    List<Ejercicio> findAllByOrderByOrdenDificultad();
    */

    //Filtrar los ejercicios por dificultad o tipo y ordernar el resultado por la dificultad
    @Query("{$and: [ { $or: [ { 'dificultad_ejercicio': ?0 }, { ?0: null } ] }," +
            " { $or: [ { 'tipo_ejercicio': ?1 }, { ?1: null } ] } ] }")
    List<Ejercicio> findByDificultadEjercicioAndTipoEjercicioOrderByOrdenDificultad(String dificultadEjercicio, String tipoEjercicio);


}
