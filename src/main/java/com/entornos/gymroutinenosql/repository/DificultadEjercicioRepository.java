package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.DificultadEjercicio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DificultadEjercicioRepository extends MongoRepository<DificultadEjercicio, String> {

}
