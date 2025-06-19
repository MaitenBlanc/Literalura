package com.aluracursos.literalura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluracursos.literalura.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBirthYearBeforeAndDeathYearAfter(Integer year, Integer year2);

    Optional<Author> findByNameContainingIgnoreCase(String name);

    List<Author> findByBirthYearLessThan(Integer year);

    List<Author> findByDeathYearGreaterThan(Integer year);

}