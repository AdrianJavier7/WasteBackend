package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.UsuarioRepository;
import org.example.wasteback.dto.UsuarioDTO;
import org.example.wasteback.dto.UsuarioPagosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO getById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        if(usuario != null) {
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setCorreo(usuario.getCorreo());
            usuarioDTO.setNumeroTelefono(usuario.getNumeroTelefono());
            usuarioDTO.setContrasena(usuario.getContrasena());
            usuarioDTO.setEstado(usuario.getEstado());
            return usuarioDTO;
        }
        return null;

    }
    public Usuario getByIdUsr(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public UsuarioPagosDTO getPagosUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        UsuarioPagosDTO usuarioPagosDTO = new UsuarioPagosDTO();
        if(usuario != null) {
            usuarioPagosDTO.setId(usuario.getId());
            usuarioPagosDTO.setNombre(usuario.getNombre());
            usuarioPagosDTO.setCorreo(usuario.getCorreo());
            usuarioPagosDTO.setNumeroTelefono(usuario.getNumeroTelefono());
            usuarioPagosDTO.setEstado(usuario.getEstado());
            usuarioPagosDTO.setPagos(usuario.getPagos());
            return usuarioPagosDTO;
        }
        return null;
    }

    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for(Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setCorreo(usuario.getCorreo());
            usuarioDTO.setNumeroTelefono(usuario.getNumeroTelefono());
            usuarioDTO.setContrasena(usuario.getContrasena());
            usuarioDTO.setEstado(usuario.getEstado());
            usuariosDTO.add(usuarioDTO);
        }
            return usuariosDTO;
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
