package com.entornos.gymroutinenosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "autorizacion")

public class Autorizacion {

    @Id
    private String id;
    private String idUsuario;
    private String clave;
    @Field("fecha_inicio")
    private LocalDateTime fechaInicio;
    @Field("fecha_fin")
    private LocalDateTime fechaFin;

    //Relaciones
    @DBRef(lazy = true)
    @Transient
    private Usuario usuario;
}
