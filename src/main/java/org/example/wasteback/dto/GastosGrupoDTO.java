package org.example.wasteback.dto;

import lombok.Data;

@Data
public class GastosGrupoDTO {

        private Integer id;
        private String nombre;
        private String descripcion;
        private Double importe;

        private Integer idGrupo;
}
