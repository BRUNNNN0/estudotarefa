package com.example.estudar.service;

import com.example.estudar.model.UsuarioModel;
import com.example.estudar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Usuarioservice {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel criarusuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }


    public UsuarioModel updateusuarios(int id, UsuarioModel usuario) {
        Optional<UsuarioModel> usuarioselecionado = usuarioRepository.findById(id);
        usuarioselecionado.get().setNomeUsuario(usuario.getNomeUsuario());
        usuarioselecionado.get().setEmail(usuario.getEmail());
        usuarioselecionado.get().setTelefone(usuario.getTelefone());
        return usuarioRepository.save(usuarioselecionado.get());
    }
}
