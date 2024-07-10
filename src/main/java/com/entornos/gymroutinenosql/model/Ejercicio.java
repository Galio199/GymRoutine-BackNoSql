package com.entornos.gymroutinenosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "ejercicios")
public class Ejercicio {

    @Id
    private String id;
    private String nombre;
    @Field("dificultad_ejercicio")
    private String dificultadEjercicio;
    @Field("orden_dificultad")
    private int ordenDificultad;
    @Field("tipo_ejercicio")
    private String tipoEjercicio;

}
