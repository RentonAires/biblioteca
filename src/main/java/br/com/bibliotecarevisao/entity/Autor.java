package br.com.bibliotecarevisao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @Column(name = "autor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String sobrenome;
}
