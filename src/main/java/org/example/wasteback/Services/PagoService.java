package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Gasto;
import org.example.wasteback.Entitys.Grupo;
import org.example.wasteback.Entitys.Pago;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.PagoRepository;
import org.example.wasteback.dto.GastosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private GastoService gastoService;

    public Pago getById(Integer id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    public void eliminar(Integer id) {
        pagoRepository.deleteById(id);
    }


    public HashMap<String, Double> getBalance(Integer grupoId) {

        HashMap<String, Double> balancesPorUsuario = new HashMap<>();

        List<GastosDTO> gastos = gastoService.getGastosByGrupo2(grupoId);

        Grupo grupo = grupoService.getGrupoById(grupoId);

        Double totalGastos = 0.0;

        for( GastosDTO gasto: gastos ){
            totalGastos += gasto.getImporte();
        }

        Double cadaUsuarioPaga = totalGastos / grupo.getUsuarios().size();

        for(Usuario usuario: grupo.getUsuarios()){

            if(!usuario.getPagos().isEmpty()){
                System.out.println("Si pase " + usuario.getNombre());
                for( Pago pago: usuario.getPagos() ){
                        cadaUsuarioPaga -= pago.getImporte();
                        balancesPorUsuario.put(usuario.getNombre(), cadaUsuarioPaga);
                }
                System.out.println(balancesPorUsuario);
            } else {
                System.out.println("No pase " + usuario.getNombre());
                balancesPorUsuario.put(usuario.getNombre(), 0.0);
            }
        }
        return balancesPorUsuario;
    }

}
