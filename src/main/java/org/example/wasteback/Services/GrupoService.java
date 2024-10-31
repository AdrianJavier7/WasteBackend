package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Grupo;
import org.example.wasteback.Repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public Grupo getById(Integer id) {
        return grupoRepository.findById(id).orElse(null);
    }

    public List<Grupo> getAll() {
        return grupoRepository.findAll();
    }

    public Grupo guardar(Grupo usuario) {
        return grupoRepository.save(usuario);
    }

    public void eliminar(Integer id) {
        grupoRepository.deleteById(id);
    }
}
