package com.maria.gerenciamento_biblioteca.dtos;

import java.time.LocalDate;

import com.maria.gerenciamento_biblioteca.domain.Livro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroResponseDto {

    private Integer id;
    private String nome;
    private LocalDate dataLancamento;
    private boolean disponivel;
    private AutorResponseDto autor;

    public LivroResponseDto(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.dataLancamento = livro.getDataLancamento();
        this.disponivel = livro.isDisponivel();
        if (livro.getAutor() != null) {
            this.autor = new AutorResponseDto(livro.getAutor());
        }
    }
}

