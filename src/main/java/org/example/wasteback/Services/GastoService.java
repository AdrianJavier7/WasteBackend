package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Gasto;
import org.example.wasteback.Repositories.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public Gasto getById(Integer id) {
        return gastoRepository.findById(id).orElse(null);
    }

    public List<Gasto> getAll() {
        return gastoRepository.findAll();
    }

    public Gasto guardar(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public void eliminar(Integer id) {
        gastoRepository.deleteById(id);
    }
}
