package org.example.wasteback;

import org.example.wasteback.Services.GastoService;
import org.example.wasteback.dto.GastosGrupoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GastoServiceTestIntegracion {

    @Mock
    private GastoService gastoService;

    @Test
    public void crearGasto() {
        GastosGrupoDTO gastoDTO = new GastosGrupoDTO();
        gastoDTO.setNombre("Gasto 1");
        gastoDTO.setDescripcion("Descripcion del gasto 1");
        gastoDTO.setImporte(100.0);
        gastoDTO.setIdGrupo(1);

        gastoService.guardar(gastoDTO);

        verify(gastoService, times(1)).guardar(gastoDTO);
    }
}