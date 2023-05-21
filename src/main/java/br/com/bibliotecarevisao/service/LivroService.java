package br.com.bibliotecarevisao.service;

import br.com.bibliotecarevisao.entity.Autor;
import br.com.bibliotecarevisao.entity.Livro;
import br.com.bibliotecarevisao.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorService autorService;

    //listando livro
    public List<Livro> listar(){
        return livroRepository.findAll();
    }

    //salvar livro
    public Livro salvar(Livro livro) throws Exception{
        //if (livro.getId() != null){
         //   listarPorId(livro.getId());
       // }

        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()){
            throw new Exception("Titulo do a livro e obrigatório!");
        }

        if (livro.getAutor() == null ){
            throw new Exception("Autor é obrigatório!");
        }

        Autor autor;

        try {
            autor = autorService.listarPorId(livro.getAutor().getId());
        }catch (Exception e){
            autor = autorService.salvar(livro.getAutor());
        }

        livro.setAutor(autor);

        if (livro.getCategoria() == null || livro.getCategoria().isEmpty()){
            throw new Exception("A categoria é obrigatória! ");
        }

        if (livro.getEditora() == null || livro.getEditora().isEmpty()){
            throw new Exception("Editora é obrigatório!");
        }

        if (livro.getExemplares() == null || livro.getExemplares() < 0){
            livro.setExemplares(0);
        }

        livro.setDisponibilidade(livro.getExemplares() > 0);

        livroRepository.save(livro);
        return livro;
    }
    //listando livro por id
    public Livro listarPorId(Long id) throws Exception{
        Optional<Livro> livroPesquisado = livroRepository.findById(id);
        if (livroPesquisado.isEmpty()){
            throw new Exception("Livro não encontrado!");
        }
        return livroPesquisado.get();
    }

    //editar deletar
    public boolean deletar(Long id) throws  Exception{
        Livro livro =listarPorId(id);
        try {
            livroRepository.delete(livro);
        }catch (Exception e){
            return false;
        }
        return true;
    }


}
