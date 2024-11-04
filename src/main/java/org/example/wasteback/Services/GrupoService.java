package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Grupo;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.GrupoRepository;
import org.example.wasteback.Repositories.UsuarioRepository;
import org.example.wasteback.dto.GrupoDTO;
import org.example.wasteback.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public GrupoDTO getById(Integer id) {
        Grupo grupo = grupoRepository.findById(id).orElse(null);
        GrupoDTO grupoDTO = new GrupoDTO();

        if (grupo != null) {
            grupoDTO.setId(grupo.getId());
            grupoDTO.setNombre(grupo.getNombre());
            return grupoDTO;
        }
        return null;
    }

    public List<GrupoDTO> getAll() {
        List<Grupo> grupos = grupoRepository.findAll();
        List<GrupoDTO> gruposDTO = new java.util.ArrayList<>();

        for (Grupo grupo : grupos) {
            GrupoDTO grupoDTO = new GrupoDTO();
            grupoDTO.setId(grupo.getId());
            grupoDTO.setNombre(grupo.getNombre());
            gruposDTO.add(grupoDTO);
        }
        return gruposDTO;
    }

    public Grupo guardar(Grupo usuario) {
        return grupoRepository.save(usuario);
    }

    public void eliminar(Integer id) {
        grupoRepository.deleteById(id);
    }

    public void anyadirUsuarioGrupo(Integer groupId, List<Integer> userIds) {
        Grupo grupo = grupoRepository.findById(groupId).orElse(null);
        if (grupo != null) {
            List<Usuario> usuarios = usuarioRepository.findAllById(userIds);
            grupo.setUsuarios(usuarios);
            grupoRepository.save(grupo);
        }
    }
    public List<UsuarioDTO> getUsuariosGrupo(Integer idGrupo) {
        Grupo grupo = grupoRepository.findById(idGrupo).orElse(null);
        if (grupo != null) {
            List<Usuario> usuarios = grupo.getUsuarios();
            List<UsuarioDTO> usuariosDTO = new java.util.ArrayList<>();

            for (Usuario usuario : usuarios) {
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
        return null;
    }

    public void eliminarUsuarioGrupo(Integer groupId, List<Integer> userIds) {
        Grupo grupo = grupoRepository.findById(groupId).orElse(null);
        if (grupo != null) {
            List<Usuario> usuarios = grupo.getUsuarios();
            usuarios.removeIf(usuario -> userIds.contains(usuario.getId()));
            grupo.setUsuarios(usuarios);
            grupoRepository.save(grupo);
        }
    }
}
