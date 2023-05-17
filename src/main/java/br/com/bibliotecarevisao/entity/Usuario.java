package br.com.bibliotecarevisao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String documento;

    @Column(length = 120, nullable = false)
    private String email;

    @Column(length = 16)
    private String telefone;

    @Column(nullable = false)
    private Boolean bloqueado = false;
}
