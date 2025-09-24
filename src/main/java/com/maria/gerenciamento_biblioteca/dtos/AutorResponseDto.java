package com.maria.gerenciamento_biblioteca.dtos;

import com.maria.gerenciamento_biblioteca.domain.model.Autor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorResponseDto {
    private Integer id;
    private String nome;

    public AutorResponseDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
    }
}