package org.example.wasteback.controllers;

import lombok.AllArgsConstructor;
import org.example.wasteback.Entitys.Gasto;
import org.example.wasteback.Services.GastoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gasto")
@AllArgsConstructor
public class GastoController {

        private final GastoService gastoService;

        @GetMapping("/{id}")
        public Gasto getById(@PathVariable Integer id) {
            return gastoService.getById(id);
        }

        @GetMapping
        public List<Gasto> getAll() {
            return gastoService.getAll();
        }

        @PostMapping("/guardar")
        public Gasto guardar(@RequestBody Gasto gasto) {
            return gastoService.guardar(gasto);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Integer id) {
            gastoService.eliminar(id);
        }
}