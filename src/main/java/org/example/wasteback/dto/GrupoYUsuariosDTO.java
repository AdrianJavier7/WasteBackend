package org.example.wasteback.dto;

import lombok.Data;

import java.util.List;

@Data
public class GrupoYUsuariosDTO {

    private Integer id;
    private String nombre;
    List<UsuarioDTO> usuarios;

}
