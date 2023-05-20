package br.com.bibliotecarevisao.repository;

import br.com.bibliotecarevisao.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
