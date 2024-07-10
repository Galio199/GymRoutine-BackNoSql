package com.entornos.gymroutinenosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "rutina")

public class Rutina {

    @Id
    private String id;
    private String nombre;
    @Field("tipo_rutina")
    private List<String> tipoRutina;
    @Field("dificultad_rutina")
    private String dificultadRutina;
    @Field("orden_dificultad")
    private int ordenDificultad;
    private String dia;
    private boolean publicada;
    private List<String> ejercicios;

}
