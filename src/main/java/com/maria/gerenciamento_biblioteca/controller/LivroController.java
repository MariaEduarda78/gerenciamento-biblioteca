package com.maria.gerenciamento_biblioteca.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maria.gerenciamento_biblioteca.domain.Livro;
import com.maria.gerenciamento_biblioteca.dtos.LivroResponseDto;
import com.maria.gerenciamento_biblioteca.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<LivroResponseDto> listar() {
        return livroRepository.findAll().stream()
                .map(LivroResponseDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) 
    public Livro salvarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deletarLivro(@PathVariable Integer id) {
        if (!livroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}") 
    public ResponseEntity<LivroResponseDto> buscarPorId(@PathVariable Integer id) {
        return livroRepository.findById(id)
                .map(LivroResponseDto::new) 
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}