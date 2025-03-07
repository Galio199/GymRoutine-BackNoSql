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
@Document(value = "usuarios")

public class Usuario {

    @Id
    private String id;
    private String username;
    private String nombre;
    private String apellido;
    @Field("fecha_creacion")
    private LocalDateTime fechaCreacion;

}
