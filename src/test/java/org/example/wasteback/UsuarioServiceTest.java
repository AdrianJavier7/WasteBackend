package org.example.wasteback;

import jakarta.transaction.Transactional;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Services.UsuarioService;
import org.example.wasteback.dto.UsuarioDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    // test de obtener amigos
    @Test
    @Transactional
    @DisplayName("Obtener amigos")
    public void obtenerAmigosPositivo() {
        assertNotNull(usuarioService.getAmigos(1));
    }

    // test de obtener amigos
    @Test
    @Transactional
    @DisplayName("Obtener amigos")
    public void obtenerAmigosNegativo() {
        Usuario usuario = usuarioService.getByIdUsr(1);
        usuario.setAmigos(null);
        assertThrows(RuntimeException.class, () -> usuarioService.getAmigos(1));
    }

}
