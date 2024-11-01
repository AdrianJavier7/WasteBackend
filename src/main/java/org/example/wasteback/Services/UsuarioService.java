package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
    public List<Usuario> getAmigos(Integer userId) {
        Usuario usuario = usuarioRepository.findById(userId).orElse(null);
        if (usuario != null) {
            return usuario.getAmigos();
        }
        return null;
    }
}
