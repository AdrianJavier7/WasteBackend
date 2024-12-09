package org.example.wasteback.Services;

import org.example.wasteback.Entitys.Grupo;
import org.example.wasteback.Entitys.Usuario;
import org.example.wasteback.Repositories.GrupoRepository;
import org.example.wasteback.Repositories.UsuarioRepository;
import org.example.wasteback.dto.EliminarUsrDTO;
import org.example.wasteback.dto.GrupoDTO;
import org.example.wasteback.dto.GrupoYUsuariosDTO;
import org.example.wasteback.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            List<String> participantes = new ArrayList<>();
            List<Integer> idParticipantes = new ArrayList<>();
            for (Usuario usuario : grupo.getUsuarios()) {
                participantes.add(usuario.getNombre());
                idParticipantes.add(usuario.getId());
            }
            grupoDTO.setParticipantes(participantes);
            grupoDTO.setIdParticipantes(idParticipantes);
            return grupoDTO;
        }
        return null;
    }

    public Grupo getGrupoById(Integer id) {
        return grupoRepository.findById(id).orElse(null);
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

    public List<GrupoDTO> getGruposUsuario(Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            List<Grupo> grupos = usuario.getGrupos();
            List<GrupoDTO> gruposDTO = new java.util.ArrayList<>();

            if(grupos == null || grupos.isEmpty()) {
                throw new IllegalArgumentException("El usuario no tiene grupos");
            }
            for (Grupo grupo : grupos) {
                GrupoDTO grupoDTO = new GrupoDTO();
                grupoDTO.setId(grupo.getId());
                grupoDTO.setNombre(grupo.getNombre());

                List<String> participantes = new ArrayList<>();
                List<Integer> idParticipantes = new ArrayList<>();
                for (Usuario usuario1 : grupo.getUsuarios()) {
                    participantes.add(usuario1.getNombre());
                    idParticipantes.add(usuario1.getId());
                }
                grupoDTO.setParticipantes(participantes);
                grupoDTO.setIdParticipantes(idParticipantes);

                gruposDTO.add(grupoDTO);
            }
            return gruposDTO;
        }
        throw new IllegalArgumentException("El usuario no existe");
    }
    public GrupoDTO guardar(GrupoDTO grupoDTO) {
        if (grupoDTO == null || grupoDTO.getNombre() == null || grupoDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El grupo no puede ser nulo o vacio");
        }

        try {
            Grupo grupo = new Grupo();
            grupo.setNombre(grupoDTO.getNombre());
            List<Usuario> usuarios = new ArrayList<>();

            for (Integer id : grupoDTO.getIdParticipantes()) {
                Usuario usuario = usuarioRepository.findById(id).orElse(null);
                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
            grupo.setUsuarios(usuarios);
            grupo = grupoRepository.save(grupo);

            grupoDTO.setId(grupo.getId());
            return grupoDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminar(Integer id) {
        grupoRepository.deleteById(id);
    }

    public GrupoYUsuariosDTO anyadirUsuarioGrupo(Integer groupId, Integer userIds) {
        Grupo grupo = grupoRepository.findById(groupId).orElse(null);
        if (grupo != null) {
            Usuario usuario = usuarioRepository.findById(userIds).orElse(null);
            if (usuario != null && !grupo.getUsuarios().contains(usuario)) {
                List<Usuario> usuarios = grupo.getUsuarios();
                usuarios.add(usuario);
                grupo.setUsuarios(usuarios);
                grupoRepository.save(grupo);
                GrupoYUsuariosDTO grupoYUsuariosDTO = new GrupoYUsuariosDTO();

                grupoYUsuariosDTO.setId(grupo.getId());
                grupoYUsuariosDTO.setNombre(grupo.getNombre());
                List<UsuarioDTO> usuariosDTO = new java.util.ArrayList<>();
                for (Usuario usuario1 : usuarios) {
                    UsuarioDTO usuarioDTO = new UsuarioDTO();
                    usuarioDTO.setId(usuario1.getId());
                    usuarioDTO.setNombre(usuario1.getNombre());
                    usuarioDTO.setCorreo(usuario1.getCorreo());
                    usuarioDTO.setNumeroTelefono(usuario1.getNumeroTelefono());
                    usuarioDTO.setContrasena(usuario1.getContrasena());
                    usuarioDTO.setEstado(usuario1.getEstado());
                    usuariosDTO.add(usuarioDTO);
                }
                grupoYUsuariosDTO.setUsuarios(usuariosDTO);
                return grupoYUsuariosDTO;


            }
            throw new IllegalArgumentException("El usuario ya pertenece al grupo");
        }
        return null;
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
        throw new IllegalArgumentException("El grupo no existe");
    }

    public Boolean eliminarUsuarioGrupo(EliminarUsrDTO eliminarUsrDTO) {
        Grupo grupo = grupoRepository.findById(eliminarUsrDTO.getIdGrupo()).orElse(null);
        if (grupo != null) {
            Usuario usuario = usuarioRepository.findById(eliminarUsrDTO.getIdUsuario()).orElse(null);
            if (usuario != null) {
                List<Usuario> usuarios = grupo.getUsuarios();
                usuarios.remove(usuario);
                grupo.setUsuarios(usuarios);
                grupoRepository.save(grupo);
                return true;
            }
        }
        return false;
    }

    public GrupoDTO getByName(String nombre) {
        Grupo grupo = grupoRepository.findByNombre(nombre);
        GrupoDTO grupoDTO = new GrupoDTO();

        if (grupo != null) {
            grupoDTO.setId(grupo.getId());
            grupoDTO.setNombre(grupo.getNombre());
            List<String> participantes = new ArrayList<>();
            for (Usuario usuario : grupo.getUsuarios()) {
                participantes.add(usuario.getNombre());
            }
            grupoDTO.setParticipantes(participantes);
            return grupoDTO;
        }
        return null;
    }
}

