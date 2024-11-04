package org.example.wasteback.dto;

import lombok.Data;
import org.example.wasteback.Entitys.Pago;

import java.util.List;

@Data
public class UsuarioPagosDTO {

    private  Integer id;
    private String nombre;
    private String correo;
    private String numeroTelefono;
    private String estado;
    private List<Pago> pagos;

}
