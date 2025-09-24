package com.maria.gerenciamento_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maria.gerenciamento_biblioteca.domain.model.Autor;


public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
