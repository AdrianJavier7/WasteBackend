package org.example.wasteback.dto;

import lombok.Data;

import java.util.List;

@Data
public class GrupoDTO {

    private Integer id;
    private String nombre;
    private List<String> participantes;
    private List<Integer> idParticipantes;
}
