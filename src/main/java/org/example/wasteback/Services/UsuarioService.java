package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.UsuarioRepository;
import org.example.wasteback.controllers.AmigosDTO;
import org.example.wasteback.dto.UsuarioDTO;
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
    public List<AmigosDTO> getAmigos(Integer userId) {
        Usuario usuario = usuarioRepository.findById(userId).orElse(null);
        List<AmigosDTO> amigosDTO = new ArrayList<>();
        if (usuario != null) {

            for (Usuario amigo : usuario.getAmigos()) {

                AmigosDTO amigos = new AmigosDTO();
                amigos.setId(amigo.getId());
                amigos.setNombre(amigo.getNombre());
                amigosDTO.add(amigos);
            }

            return amigosDTO;
        }
        return null;
    }

}
