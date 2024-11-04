package org.example.wasteback.controllers;

import lombok.AllArgsConstructor;
import org.example.wasteback.Entitys.Grupo;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Services.GrupoService;
import org.example.wasteback.dto.GrupoDTO;
import org.example.wasteback.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupo")
@AllArgsConstructor
public class GrupoController {

        private final GrupoService grupoService;

        @GetMapping("/{id}")
        public GrupoDTO getById(@PathVariable Integer id) {
            return grupoService.getById(id);
        }

        @GetMapping
        public List<GrupoDTO> getAll() {
            return grupoService.getAll();
        }

        @PostMapping("/guardar")
        public Grupo guardar(@RequestBody Grupo grupo) {
            return grupoService.guardar(grupo);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Integer id) {
            grupoService.eliminar(id);
        }

        @PostMapping("/añadirUsuarioGrupo")
        public void anyadirUsuarioGrupo(@RequestParam Integer groupId, @RequestParam List<Integer> userIds) {
            grupoService.anyadirUsuarioGrupo(groupId, userIds);
        }
        @GetMapping("/{id}/participantes")
        public List<UsuarioDTO> getUsuariosGrupo(@PathVariable Integer id) {
            return grupoService.getUsuariosGrupo(id);
        }

        @DeleteMapping("/{id}/eliminarUsuarioGrupo")
        public void eliminarUsuarioGrupo(@PathVariable Integer id, @RequestParam List<Integer> userIds) {
            grupoService.eliminarUsuarioGrupo(id, userIds);
        }

}
