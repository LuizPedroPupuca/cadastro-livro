package br.com.zup.edu.cadastrolivro;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class LivroRequest {
    @NotBlank @Size(max = 200)
    private String titulo;

    @NotBlank @Size(max = 4000)
    private String descricao;

    @NotNull @Past @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @ISBN(type = ISBN.Type.ANY)
    private String isbn;

    public LivroRequest(String titulo, String descricao, LocalDate dataPublicacao, String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    public LivroRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro toModel() {
        return new Livro(titulo, descricao, dataPublicacao, isbn);
    }
}
