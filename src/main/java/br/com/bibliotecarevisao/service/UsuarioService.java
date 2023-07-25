package br.com.bibliotecarevisao.service;

import br.com.bibliotecarevisao.entity.Usuario;
import br.com.bibliotecarevisao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuario(){
        return this.usuarioRepository.findAll();
    }
}
