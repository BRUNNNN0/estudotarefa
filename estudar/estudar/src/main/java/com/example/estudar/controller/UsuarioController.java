package com.example.estudar.controller;

import com.example.estudar.model.UsuarioModel;
import com.example.estudar.service.Usuarioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private Usuarioservice usuarioservice;

    @PostMapping
    public UsuarioModel criarusuario(@RequestBody UsuarioModel usuario){
        return usuarioservice.criarusuario(usuario);
    }

    @PutMapping("/{id}")//
    public UsuarioModel updateusuarios(@PathVariable int id, @RequestBody UsuarioModel usuario){
        return usuarioservice.updateusuarios(id, usuario);
    }
}
