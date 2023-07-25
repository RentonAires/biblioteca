package br.com.bibliotecarevisao.controller;

import br.com.bibliotecarevisao.entity.Usuario;
import br.com.bibliotecarevisao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public List<Usuario> get(){
        return this.usuarioService.listarUsuario();
    }


}
