package com.aluracursos.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    @JsonAlias("results")
    private List<LibroJson> libros;

    public List<LibroJson> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroJson> libros) {
        this.libros = libros;
    }
}
