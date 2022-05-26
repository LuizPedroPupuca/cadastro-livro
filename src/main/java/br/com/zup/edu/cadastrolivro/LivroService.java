package br.com.zup.edu.cadastrolivro;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public ResponseEntity<?> adiciona(LivroRequest livroRequest, UriComponentsBuilder uriComponentsBuilder) {
        Livro livro = livroRequest.toModel();
        livroRepository.save(livro);

        URI location = uriComponentsBuilder.path("/livro/{id}")
                .buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
