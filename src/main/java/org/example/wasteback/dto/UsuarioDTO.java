package org.example.wasteback.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer id;
    private String nombre;
    private String correo;
    private String numeroTelefono;
    private String contrasena;
    private String estado;
}
