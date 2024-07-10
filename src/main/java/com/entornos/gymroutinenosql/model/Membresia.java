package com.entornos.gymroutinenosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "membresia")

public class Membresia {

    @Id
    private String id;
    private String idUsuario;
    @Field("fecha_inicio")
    private LocalDateTime fechaInicio;
    @Field("fecha_fin")
    private LocalDateTime fechaFin;

}
