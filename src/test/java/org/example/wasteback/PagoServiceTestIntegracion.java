package org.example.wasteback;

import org.example.wasteback.Services.PagoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class PagoServiceTestIntegracion {

    @Mock
    private PagoService pagoService;

    @Test
    public void verBalances() {
        int grupo = 1;

        pagoService.getBalance(grupo);

        verify(pagoService, times(1)).getBalance(grupo);
    }
}