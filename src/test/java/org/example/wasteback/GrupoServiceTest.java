package org.example.wasteback;


import jakarta.transaction.Transactional;
import org.example.wasteback.Services.GrupoService;
import org.example.wasteback.dto.EliminarUsrDTO;
import org.example.wasteback.dto.GrupoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GrupoServiceTest {

    @Autowired
    private GrupoService grupoService;

    // test crear grupo
    @Test
    @Transactional
    @DisplayName("Crear grupo")
    public void crearGrupo() {
        GrupoDTO grupoDTO = new GrupoDTO();
        grupoDTO.setNombre("Grupo 1");
        grupoDTO.setParticipantes(new ArrayList<>());
        grupoDTO.setIdParticipantes(new ArrayList<>());
        assertNotNull(grupoService.guardar(grupoDTO));
    }

    // Crear grupo sin nombre assertThrows
    @Test
    @Transactional
    @DisplayName("Crear grupo sin nombre")
    public void crearGrupoSinNombre() {
        GrupoDTO grupoDTO = new GrupoDTO();
        grupoDTO.setParticipantes(new ArrayList<>());
        grupoDTO.setIdParticipantes(new ArrayList<>());
        assertThrows(RuntimeException.class, () -> grupoService.guardar(grupoDTO));
    }

    // añadir participante a un grupo
    @Test
    @Transactional
    @DisplayName("Añadir participante a un grupo")
    public void anyadirParticipanteAGrupoPositivo() {
        GrupoDTO grupoDTO = grupoService.getById(1);
        assertNotNull(grupoService.anyadirUsuarioGrupo(grupoDTO.getId(), 1));
    }

    @Test
    @Transactional
    @DisplayName("Añadir participante existente a un grupo ")
    public void anyadirParticipanteAGrupoNegativo() {
        GrupoDTO grupoDTO = grupoService.getById(1);
        assertThrows(RuntimeException.class, () -> grupoService.anyadirUsuarioGrupo(grupoDTO.getId(), 4));
    }

    // test ver participantes de un grupo positivo
    @Test
    @Transactional
    @DisplayName("Ver participantes de un grupo")
    public void verParticipantesGrupoPositivo() {
        GrupoDTO grupoDTO = grupoService.getById(1);
        assertNotNull(grupoService.getUsuariosGrupo(grupoDTO.getId()));
    }

    @Test
    @Transactional
    @DisplayName("Ver participantes de un grupo que no existe")
    public void verParticipantesGrupoNegativo() {
        GrupoDTO grupoDTO = grupoService.getById(0);
        assertThrows(RuntimeException.class, () -> grupoService.getUsuariosGrupo(grupoDTO.getId()));
    }

    // test eliminar participante de un grupo
    @Test
    @Transactional
    @DisplayName("Eliminar participante de un grupo")
    public void eliminarParticipanteGrupoPositivo() {
        GrupoDTO grupoDTO = grupoService.getById(1);
        EliminarUsrDTO eliminarUsrDTO = new EliminarUsrDTO();
        eliminarUsrDTO.setIdGrupo(grupoDTO.getId());
        eliminarUsrDTO.setIdUsuario(grupoDTO.getIdParticipantes().get(0));
        assertTrue(grupoService.eliminarUsuarioGrupo(eliminarUsrDTO));
    }

    // test eliminar participante que no existe de un grupo
    @Test
    @Transactional
    @DisplayName("Eliminar participante que no existe de un grupo")
    public void eliminarParticipanteGrupoNegativo() {
        GrupoDTO grupoDTO = grupoService.getById(1);
        EliminarUsrDTO eliminarUsrDTO = new EliminarUsrDTO();
        eliminarUsrDTO.setIdGrupo(grupoDTO.getId());
        eliminarUsrDTO.setIdUsuario(0);
        assertFalse(grupoService.eliminarUsuarioGrupo(eliminarUsrDTO));
    }

    // test ver grupos de un usuario
    @Test
    @Transactional
    @DisplayName("Ver grupos de un usuario")
    public void verGruposUsuarioPositivo() {
        assertNotNull(grupoService.getGruposUsuario(1));
    }

    @Test
    @Transactional
    @DisplayName("Ver grupos de un usuario que no existe")
    public void verGruposUsuarioNegativo() {
        assertThrows(RuntimeException.class, () -> grupoService.getGruposUsuario(6));
    }

}
