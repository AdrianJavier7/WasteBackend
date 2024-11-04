package org.example.wasteback.controllers;

import lombok.AllArgsConstructor;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Services.UsuarioService;
import org.example.wasteback.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

        private final UsuarioService usuarioService;

        @GetMapping("/{id}")
        public UsuarioDTO getById(@PathVariable Integer id) {
            return usuarioService.getById(id);
        }

        @GetMapping
        public List<UsuarioDTO> getAll() {
            return usuarioService.getAll();
        }

        @PostMapping("/guardar")
        public Usuario guardar(@RequestBody Usuario usuario) {
            return usuarioService.guardar(usuario);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Integer id) {
            usuarioService.eliminar(id);
        }

        @GetMapping("/amigos/{id}")
        public List<Usuario> getAmigos(@PathVariable Integer id) {
            return usuarioService.getAmigos(id);
        }
}
