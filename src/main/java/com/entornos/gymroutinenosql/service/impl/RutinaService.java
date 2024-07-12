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

        //Comprobar si ambos parametros son nulos
        if (tipoRutina == null && dificultadRutina == null) {
            return rutinaRepository.findAllByOrderByOrdenDificultad();
        }

        //comprobar si se filtra por ambos parametros
        if (tipoRutina != null && dificultadRutina != null) {
            return rutinaRepository.findByTipoRutinaContainingAndDificultadRutinaOrderByOrdenDificultad(tipoRutina,dificultadRutina);
        }

        //Comprobar si se filtra por tipo de lo contrario filtrar por dificultad
        if (tipoRutina != null){
            return rutinaRepository.findByTipoRutinaContainingOrderByOrdenDificultad(tipoRutina);
        }else {
            return rutinaRepository.findByDificultadRutinaOrderByOrdenDificultad(dificultadRutina);
        }

    }

    //Listar las rutinas publicadas que ha creado otro usuario por el username
    @Override
    public List<Rutina> listarRutinasByUsername(String username) {
        return rutinaRepository.findByUsernameAndPublicadaOrderByOrdenDificultad(username, true);
    }

    //Listar las rutinas por el id del usuario loggeado
    @Override
    public List<Rutina> listarRutinasByIdUsuario(String idUsuario) {
        return rutinaRepository.findByIdUsuarioOrderByOrdenDificultad(idUsuario);
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
    public Rutina buscarRutina(String id) {
        return rutinaRepository.findById(id).orElse(null);
    }
}
