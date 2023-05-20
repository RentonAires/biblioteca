package br.com.bibliotecarevisao.controller;

import br.com.bibliotecarevisao.entity.Livro;
import br.com.bibliotecarevisao.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    //listando livro
    @GetMapping
    public List<Livro> get(){
        return livroService.listar();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Livro livro) {
        try {
            return ResponseEntity.ok(livroService.salvar(livro));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
