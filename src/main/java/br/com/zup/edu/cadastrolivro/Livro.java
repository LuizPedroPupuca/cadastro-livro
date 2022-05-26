package br.com.zup.edu.cadastrolivro;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false, length = 4000)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    private String isbn;

    public Livro(String titulo, String descricao, LocalDate dataPublicacao, String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    @Deprecated
    public Livro() {
    }

    public Long getId() {
        return id;
    }
}
