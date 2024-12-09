package org.example.wasteback;

import org.example.wasteback.Services.UsuarioService;
import org.example.wasteback.dto.AmigosDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTestIntegracion {

    @Mock
    private UsuarioService usuarioService;

    @Test
    public void getAmigos() {
        int userId = 1;
        List<AmigosDTO> amigos = Arrays.asList(new AmigosDTO(1, "Amigo 1"), new AmigosDTO(2, "Amigo 2"));

        when(usuarioService.getAmigos(userId)).thenReturn(amigos);

        List<AmigosDTO> result = usuarioService.getAmigos(userId);

        verify(usuarioService, times(1)).getAmigos(userId);
    }
}