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

    //salvando livro
    @PostMapping
    public ResponseEntity post(@RequestBody Livro livro) {
        try {
            return ResponseEntity.ok(livroService.salvar(livro));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //listando livro por id
    @GetMapping("{id}")
    public ResponseEntity getId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(livroService.listarPorId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //editando livro
    @PutMapping("{id}")
    public ResponseEntity put(@PathVariable Long id, @RequestBody Livro livro){
        try {
            livro.setId(null);
            return ResponseEntity.ok(livroService.salvar(livro));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //deletando livro
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(livroService.deletar(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
