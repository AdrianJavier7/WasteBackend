package org.example.wasteback;

import jakarta.transaction.Transactional;
import org.example.wasteback.Services.GastoService;
import org.example.wasteback.dto.GastosDTO;
import org.example.wasteback.dto.GastosGrupoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GastoServiceTest {

    @Autowired
    private GastoService gastoService;

    // test de crear gasto
    @Test
    @Transactional
    @DisplayName("Crear gasto")
    public void crearGasto() {
        GastosGrupoDTO gastoDTO = new GastosGrupoDTO();
        gastoDTO.setImporte(100.1);
        gastoDTO.setDescripcion("Gasto 1");
        gastoDTO.setNombre("Gasto 1");
        gastoDTO.setIdGrupo(1);
        assertNotNull(gastoService.guardar(gastoDTO));
    }

    // Crear gasto sin importe assertThrows
    @Test
    @Transactional
    @DisplayName("Crear gasto sin importe")
    public void crearGastoSinImporte() {
        GastosGrupoDTO gastoDTO = new GastosGrupoDTO();
        gastoDTO.setDescripcion("Gasto 1");
        gastoDTO.setNombre("Gasto 1");
        gastoDTO.setImporte(-1.8);
        gastoDTO.setIdGrupo(1);
        assertThrows(RuntimeException.class, () -> gastoService.guardar(gastoDTO));
    }

    @Test
    @Transactional
    @DisplayName("Crear gasto sin importe")
    public void crearGastoNegativo() {
        GastosGrupoDTO gastoDTO = new GastosGrupoDTO();
        gastoDTO.setDescripcion("Gasto 1");
        assertThrows(RuntimeException.class, () -> gastoService.guardar(gastoDTO));
    }

    @Test
    @Transactional
    @DisplayName("Ver gastos")
    public void verGastosPositivo() {
        assertNotNull(gastoService.getGastosByGrupo2(1));
    }

    @Test
    @Transactional
    @DisplayName("Ver gastos")
    public void verGastosNegativo() {
        assertNotNull(gastoService.getGastosByGrupo2(0));
    }


}
