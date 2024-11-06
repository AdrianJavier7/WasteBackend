package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Gasto;
import org.example.wasteback.Entitys.Grupo;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.GastoRepository;
import org.example.wasteback.dto.GastosDTO;
import org.example.wasteback.dto.GastosGrupoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private GrupoService grupoService;

    public GastosDTO getById(Integer id) {
        Gasto gasto = gastoRepository.findById(id).orElse(null);
        GastosDTO gastoDTO = new GastosDTO();

        if (gasto != null) {
            gastoDTO.setId(gasto.getId());
            gastoDTO.setNombre(gasto.getNombre());
            gastoDTO.setDescripcion(gasto.getDescripcion());
            gastoDTO.setImporte(gasto.getPrecio());
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
           gastosDTO.add(gastoDTO);
       }
       return gastosDTO;
    }

    public List<GastosDTO> getGastosByGrupo2(Integer idGrupo) {
        List<Gasto> gastos = gastoRepository.findAllByGrupo_Id(idGrupo);
        List<GastosDTO> gastosDTO = new ArrayList<>();

        for (Gasto gasto : gastos) {
            GastosDTO gastoDTO = new GastosDTO();
            gastoDTO.setId(gasto.getId());
            gastoDTO.setNombre(gasto.getNombre());
            gastoDTO.setDescripcion(gasto.getDescripcion());
            gastoDTO.setImporte(gasto.getPrecio());
            gastosDTO.add(gastoDTO);
        }
        return gastosDTO;
    }
    public GastosGrupoDTO guardar(GastosGrupoDTO gastoDTO) {
        Gasto gasto = new Gasto();
        gasto.setNombre(gastoDTO.getNombre());
        gasto.setDescripcion(gastoDTO.getDescripcion());
        gasto.setPrecio(gastoDTO.getImporte());
        gasto.setGrupo(grupoService.getGrupoById(gastoDTO.getIdGrupo()));
        gastoRepository.save(gasto);

        GastosGrupoDTO gastoDTO1 = new GastosGrupoDTO();
        gastoDTO1.setId(gasto.getId());
        gastoDTO1.setNombre(gasto.getNombre());
        gastoDTO1.setDescripcion(gasto.getDescripcion());
        gastoDTO1.setImporte(gasto.getPrecio());
        gastoDTO1.setIdGrupo(gasto.getGrupo().getId());

        return gastoDTO1;
    }

    public void eliminar(Integer id) {
        gastoRepository.deleteById(id);
    }
}
