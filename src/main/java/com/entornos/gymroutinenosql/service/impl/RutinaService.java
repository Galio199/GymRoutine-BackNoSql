package com.entornos.gymroutinenosql.service.impl;

import com.entornos.gymroutinenosql.model.Rutina;
import com.entornos.gymroutinenosql.repository.RutinaRepository;
import com.entornos.gymroutinenosql.service.interfaces.IRutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RutinaService implements IRutinaService {

    @Autowired
    RutinaRepository rutinaRepository;

    //Listar las rutinas publicadas filtradas por el tipo y/o la dificultad ordenadas por dificultad
    @Override
    public List<Rutina> listarRutinas(String tipoRutina, String dificultadRutina) {
        return rutinaRepository.findByTipoRutinaAndDificultadRutinaAndPublicadaOrderByOrdenDificultad(tipoRutina, dificultadRutina, true);
    }

    //Listar las rutinas publicadas que ha creado otro usuario por el username
    @Override
    public List<Rutina> listarRutinasByUsername(String username) {
        return rutinaRepository.findByUsernameAndPublicada(username, true);
    }

    //Listar las rutinas por el id del usuario loggeado
    @Override
    public List<Rutina> listarRutinasByIdUsuario(String idUsuario) {
        return rutinaRepository.findByIdUsuario(idUsuario);
    }

    //Guardar una rutina o actualizar una existente
    @Override
    public Rutina guardarRutina(Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    //Eliminar una rutina por el id
    @Override
    public boolean borrarRutina(String id) {
        rutinaRepository.deleteById(id);
        return true;
    }

    //Buscar una rutina especifica por el id
    @Override
    public Rutina buscarRutina(String id){
        return rutinaRepository.findById(id).orElse(null);
    }
}
