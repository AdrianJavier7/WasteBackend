package org.example.wasteback;

import org.example.wasteback.Services.GrupoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GrupoServiceTestIntegracion {

    @Mock
    private GrupoService grupoService;

    @Test
    public void verGruposUsuario() {
        int usuario = 1;

        grupoService.getGruposUsuario(usuario);

        verify(grupoService, times(1)).getGruposUsuario(usuario);
    }
}