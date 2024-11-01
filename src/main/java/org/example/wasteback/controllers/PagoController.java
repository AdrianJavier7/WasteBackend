package org.example.wasteback.controllers;

import lombok.AllArgsConstructor;
import org.example.wasteback.Entitys.Pago;
import org.example.wasteback.Services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
@AllArgsConstructor
public class PagoController {


    private final PagoService pagoService;

    @GetMapping("/{id}")
    public Pago getById(@PathVariable Integer id) {
        return pagoService.getById(id);
    }

    @GetMapping
    public List<Pago> getAll() {
        return pagoService.getAll();
    }

    @PostMapping("/guardar")
    public Pago guardar(@RequestBody Pago pago) {
        return pagoService.guardar(pago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        pagoService.eliminar(id);
    }

    @GetMapping("/balance/{userId}")
    public Double getBalance(@PathVariable Integer userId) {
        return pagoService.getBalance(userId);
    }
}
