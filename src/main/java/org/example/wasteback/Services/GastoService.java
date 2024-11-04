package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Gasto;
import org.example.wasteback.Repositories.GastoRepository;
import org.example.wasteback.dto.GastosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public GastosDTO getById(Integer id) {
        Gasto gasto = gastoRepository.findById(id).orElse(null);
        GastosDTO gastoDTO = new GastosDTO();

        if (gasto != null) {
            gastoDTO.setId(gasto.getId());
            gastoDTO.setNombre(gasto.getNombre());
            gastoDTO.setDescripcion(gasto.getDescripcion());
            gastoDTO.setImporte(gasto.getPrecio());
            gastoDTO.setIdPropietario(gasto.getUsuario().getId());
            gastoDTO.setIdGrupo(gasto.getGrupo().getId());
            return gastoDTO;
        }
        return null;
    }

    public List<GastosDTO> getAll() {
       List<Gasto> gastos = gastoRepository.findAll();
       List<GastosDTO> gastosDTO = new ArrayList<>();

       for (Gasto gasto : gastos) {
           GastosDTO gastoDTO = new GastosDTO();
           gastoDTO.setId(gasto.getId());
           gastoDTO.setNombre(gasto.getNombre());
           gastoDTO.setDescripcion(gasto.getDescripcion());
           gastoDTO.setImporte(gasto.getPrecio());
           gastoDTO.setIdPropietario(gasto.getUsuario().getId());
           gastoDTO.setIdGrupo(gasto.getGrupo().getId());
           gastosDTO.add(gastoDTO);
       }
       return gastosDTO;
    }

    public Gasto guardar(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public void eliminar(Integer id) {
        gastoRepository.deleteById(id);
    }
}
