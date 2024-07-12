package com.entornos.gymroutinenosql.repository;

import com.entornos.gymroutinenosql.model.Rutina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RutinaRepository extends MongoRepository<Rutina, String> {

    //Todas las rutinas se listas por dificultad

    //Listar todas las rutinas ordenadas por dificultad
    List<Rutina> findAllByOrderByOrdenDificultad();

    //Listar las rutinas filtrando por dificultad
    List<Rutina> findByDificultadRutinaOrderByOrdenDificultad(String dificultadRutina);

    //Listar las rutinas filtrando por tipo
    List<Rutina> findByTipoRutinaContainingOrderByOrdenDificultad(String tipoRutina);

    //Listar las rutinas filtrando por tipo y dificultad
    List<Rutina> findByTipoRutinaContainingAndDificultadRutinaOrderByOrdenDificultad(String tipoRutina, String dificultad);

    //Listar las rutinas publicadas que ha creado un usuario por el username
    List<Rutina> findByUsernameAndPublicadaOrderByOrdenDificultad(String username, boolean publicada);

    //Listar las rutinas que ha creado un usuario por el id del usuario
    List<Rutina> findByIdUsuarioOrderByOrdenDificultad(String idUsuario);

}
