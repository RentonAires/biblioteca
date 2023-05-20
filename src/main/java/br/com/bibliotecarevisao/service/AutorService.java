package br.com.bibliotecarevisao.service;

import br.com.bibliotecarevisao.entity.Autor;
import br.com.bibliotecarevisao.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    //exemplo de construtor sem anotação @Autowired
    //public AutorService(AutorRepository autorRepository){
    //  this.autorRepository = autorRepository;
    //}

    //listar
    public List<Autor> listar(){
        return this.autorRepository.findAll();
    }

    //salvar
    public Autor salvar(Autor autor) throws Exception{

        if (autor.getId() != null){
            if (!autorRepository.existsById(autor.getId())){
                throw new Exception("Autor não encontrado!");
            }
        }

        //verificando se o nome estar nulo ou vazio
        if (autor.getNome() == null || autor.getNome().isEmpty()){
            throw new Exception("Nome e obrigatório! ");
        }

        //verificando se o sobrenome estar nulo ou vazio
        if (autor.getSobrenome() == null || autor.getSobrenome().isEmpty()){
            throw new Exception("Sobre nome é obrigatório! ");
        }
        autor = autorRepository.save(autor);
        return autor;
    }

    //consultar_id
    public Autor listarPorId(Long id) throws Exception {
       Optional<Autor> autorPesquisado = autorRepository.findById(id);

       if (autorPesquisado.isEmpty()){
           throw new Exception("Autor não encontrado!");
       }
       return autorPesquisado.get();
    }

    //deletar
    public boolean deletar(Long id) throws Exception{
        Autor autor = listarPorId(id);
        try {
            autorRepository.delete(autor);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
