package br.com.bibliotecarevisao.controller;

import br.com.bibliotecarevisao.entity.Usuario;
import br.com.bibliotecarevisao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //listarUsuario
    @GetMapping
    public List<Usuario> get(){
        return this.usuarioService.listarUsuario();
    }
    //salvarUsuario
    @PostMapping
    public Usuario post(@RequestBody Usuario usuario){
        return this.usuarioService.salvarUsuario(usuario);
    }
    //ListarUsusarioPorId

    //EdiatrUsuario

    //deletarUsuario

}
