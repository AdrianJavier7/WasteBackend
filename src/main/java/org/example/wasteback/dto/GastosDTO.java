package org.example.wasteback.dto;

import lombok.Data;

import java.util.List;

@Data
public class GastosDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Double importe;
    private String nombreProp;
    private List<String> participantes;
}
