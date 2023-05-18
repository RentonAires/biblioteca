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
    //public AutorService(AutorRepository autorRepository){
      //  this.autorRepository = autorRepository;

    //}
    public List<Autor> listar(){
        return this.autorRepository.findAll();
    }
    public Autor salvar(Autor autor) throws Exception{

        if (autor.getId() != null){
            if (!autorRepository.existsById(autor.getId())){
                throw new Exception("Autor nao encontrado");
            }
        }

        if (autor.getNome() == null || autor.getNome().isEmpty()){
            throw new Exception("Nome e obrigatorio");
        }

        if (autor.getSobrenome() == null || autor.getSobrenome().isEmpty()){
            throw new Exception("sobre nome e obrigatorio");
        }

        autor = autorRepository.save(autor);
        return autor;
    }

    public Autor listarPorId(Long id) throws Exception {
       Optional<Autor> autorPesquisado = autorRepository.findById(id);

       if (autorPesquisado.isEmpty()){
           throw new Exception("Autor nao encontrado!");
       }
       return autorPesquisado.get();
    }



    //consultar
    //salvar
    //consultar_id
    //apagar
}
