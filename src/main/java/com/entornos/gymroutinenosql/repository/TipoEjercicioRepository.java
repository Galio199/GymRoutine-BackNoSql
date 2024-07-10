package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.TipoEjercicio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEjercicioRepository extends MongoRepository<TipoEjercicio, String> {
}
