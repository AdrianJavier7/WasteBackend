package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Grupo;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.GrupoRepository;
import org.example.wasteback.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

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

    public void anyadirUsuarioGrupo(Integer groupId, List<Integer> userIds) {
        Grupo grupo = grupoRepository.findById(groupId).orElse(null);
        if (grupo != null) {
            List<Usuario> usuarios = usuarioRepository.findAllById(userIds);
            grupo.setUsuarios(usuarios);
            grupoRepository.save(grupo);
        }
    }
    public List<Usuario> getUsuariosGrupo(Integer groupId) {
        Grupo grupo = grupoRepository.findById(groupId).orElse(null);
        if (grupo != null) {
            return grupo.getUsuarios();
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
