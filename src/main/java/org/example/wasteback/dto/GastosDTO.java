package org.example.wasteback.dto;

import lombok.Data;

@Data
public class GastosDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Double importe;
    private Integer idPropietario;
    private Integer idGrupo;
}
