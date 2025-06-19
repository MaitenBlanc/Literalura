package com.aluracursos.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluracursos.literalura.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByLanguage(String language);

    List<Libro> findByLanguageIn(List<String> languages);
}