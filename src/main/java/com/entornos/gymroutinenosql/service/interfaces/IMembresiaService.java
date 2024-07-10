package com.entornos.gymroutinenosql.service.interfaces;

import com.entornos.gymroutinenosql.model.Membresia;

import java.util.List;

public interface IMembresiaService  {

    //Listar las memebresias que tiene un usuario
    List<Membresia> listarMembresiasByIdUsuario(String idUsuario);

    //Guardar o actualizar una memebresia
    Membresia guardarMembresia(Membresia membresia);

    //Buscar una membresia especifica por el id
    Membresia buscarMembresia(String id);

    int borrarMembresia(String id);

}
