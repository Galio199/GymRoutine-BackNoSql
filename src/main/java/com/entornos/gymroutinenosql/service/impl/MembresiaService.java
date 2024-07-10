package com.entornos.gymroutinenosql.service.impl;

import com.entornos.gymroutinenosql.model.Membresia;
import com.entornos.gymroutinenosql.repository.MembresiaRepository;
import com.entornos.gymroutinenosql.service.interfaces.IMembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MembresiaService implements IMembresiaService {

    @Autowired
    MembresiaRepository membresiaRepository;

    //Listar las membresias que tiene un usuario
    @Override
    public List<Membresia> listarMembresiasByIdUsuario(String idUsuario) {
        return membresiaRepository.findByIdUsuario(idUsuario);
    }

    //Guardar o actualizar una memebresia
    @Override
    public Membresia guardarMembresia(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    //Buscar una membresia especifica por el id
    @Override
    public Membresia buscarMembresia(String id) {
        return membresiaRepository.findById(id).orElse(null);
    }

    @Override
    public int borrarMembresia(String id) {
        membresiaRepository.deleteById(id);
        return 1;
    }
}
