package com.maria.gerenciamento_biblioteca.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maria.gerenciamento_biblioteca.domain.model.Autor;
import com.maria.gerenciamento_biblioteca.dtos.AutorResponseDto;
import com.maria.gerenciamento_biblioteca.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<AutorResponseDto> listar() {
        return autorRepository.findAll().stream()
                .map(AutorResponseDto::new).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor salvarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDto> buscarPorId(@PathVariable Integer id) {
        return autorRepository.findById(id)
                .map(AutorResponseDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
