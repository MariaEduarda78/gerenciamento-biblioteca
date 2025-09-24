package com.maria.gerenciamento_biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maria.gerenciamento_biblioteca.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByNome(String nome);

}
