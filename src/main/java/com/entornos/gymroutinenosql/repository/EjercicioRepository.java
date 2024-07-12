package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.Ejercicio;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface EjercicioRepository extends MongoRepository<Ejercicio, String> {

    //Todas las listas se ordenan por la dificultad

    //Listar todos los ejercicios
    List<Ejercicio> findAllByOrderByOrdenDificultad();

    //Listar los ejercicios filtrando por dificultad
    List<Ejercicio> findByDificultadEjercicioOrderByOrdenDificultad(String dificultadEjercicio);

    //Listar los ejercicios filtrando por tipo
    List<Ejercicio> findByTipoEjercicioOrderByOrdenDificultad(String tipoEjercicio);

    //Listar los ejercicios filtrando por tipo y dificultad
    List<Ejercicio> findByDificultadEjercicioAndTipoEjercicioOrderByOrdenDificultad(String dificultadEjercicio, String tipoEjercicio);

}
