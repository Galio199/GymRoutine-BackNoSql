package com.entornos.gymroutinenosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "autorizacion")

public class Autorizacion {

    @Id
    private String id;
    @Field(name = "id_usuario", targetType = FieldType.OBJECT_ID)
    private String idUsuario;
    private String clave;
    @Field("fecha_inicio")
    private LocalDateTime fechaInicio;
    @Field("fecha_fin")
    private LocalDateTime fechaFin;

    //Relaciones
    @DBRef(lazy = true)
    private Usuario usuario;

}
