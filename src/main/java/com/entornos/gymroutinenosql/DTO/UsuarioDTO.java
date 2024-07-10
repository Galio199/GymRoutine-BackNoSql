package com.entornos.gymroutinenosql.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private String username;
    private String nombre;
    private String apellido;
    private String clave;
}
