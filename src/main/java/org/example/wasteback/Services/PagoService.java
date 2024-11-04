package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Pago;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.PagoRepository;
import org.example.wasteback.Repositories.UsuarioRepository;
import org.example.wasteback.dto.UsuarioPagosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private UsuarioService usuarioService;

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


    public Double getBalance(Integer usuarioId) {
        UsuarioPagosDTO usuario = usuarioService.getPagosUsuario(usuarioId);
        List<Pago> pagos = usuario.getPagos();
        Double balance = 0.0;
        for (Pago pago : pagos) {
            balance += pago.getImporte();
        }
        return balance;
    }

}
