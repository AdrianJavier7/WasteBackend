package org.example.wasteback.controllers;

import lombok.AllArgsConstructor;
import org.example.wasteback.Entitys.Grupo;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Services.GastoService;
import org.example.wasteback.Services.GrupoService;
import org.example.wasteback.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupo")
@AllArgsConstructor
public class GrupoController {

        private final GrupoService grupoService;

        private final GastoService gastoService;

        @GetMapping("/{id}")
        public GrupoDTO getById(@PathVariable Integer id) {
            return grupoService.getById(id);
        }


        @GetMapping({"/usuario/{id}"})
        public List<GrupoDTO> getGruposUsuario(@PathVariable Integer id) {
            return grupoService.getGruposUsuario(id);
        }

        @GetMapping("/gastos/{idGrupo}")
        public List<GastosDTO> getGastosByGrupo(@PathVariable Integer idGrupo) {
            return gastoService.getGastosByGrupo2(idGrupo);
        }

        @PostMapping("/guardar")
        public GrupoDTO guardar(@RequestBody GrupoDTO grupoDTO) {
            return grupoService.guardar(grupoDTO);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Integer id) {
            grupoService.eliminar(id);
        }

        @PostMapping("/añadirUsuarioGrupo/{groupId}/{idUsuario}")
        public GrupoYUsuariosDTO anyadirUsuarioGrupo(@PathVariable Integer groupId, @PathVariable Integer idUsuario) {
            return grupoService.anyadirUsuarioGrupo(groupId, idUsuario);
        }
        @GetMapping("/participantes/{idGrupo}")
        public List<UsuarioDTO> getUsuariosGrupo(@PathVariable Integer idGrupo) {
            return grupoService.getUsuariosGrupo(idGrupo);
        }

        @DeleteMapping("/eliminarUsuarioGrupo")
        public void eliminarUsuarioGrupo(@RequestBody EliminarUsrDTO eliminarUsrDTO) {
            grupoService.eliminarUsuarioGrupo(eliminarUsrDTO);
        }


}
