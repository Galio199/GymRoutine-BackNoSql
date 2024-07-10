package com.entornos.gymroutinenosql.service.interfaces;

import com.entornos.gymroutinenosql.model.Rutina;

import java.util.List;

public interface IRutinaService {

    //Listar las rutinas filtradas por el tipo y/o la dificultad ordenadas por dificultad
    List<Rutina> listarRutinas(String tipoRutina, String dificultadRutina);

    //Listar las rutinas que ha creado otro usuario por el username
    List<Rutina> listarRutinasByUsername(String username);

    //Listar las rutinas por el id del usuario loggeado
    List<Rutina> listarRutinasByIdUsuario(String idUsuario);

    //Guardar una rutina o actualizar una existente
    Rutina guardarRutina(Rutina rutina);

    //Eliminar una rutina por el id
    boolean borrarRutina(String id);

    //Buscar una rutina por el id
    Rutina buscarRutina(String id);

}
