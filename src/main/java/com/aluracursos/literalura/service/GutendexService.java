package com.aluracursos.literalura.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GutendexService {
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private IConvierteDatos conversor;
    @Autowired
    private LibroRepository bookRepo;
    @Autowired
    private AuthorRepository authorRepo;

    public Libro buscarYGuardarLibro(String titulo) {
        try {
            String urlStr = "https://gutendex.com/books/?search=" + URLEncoder.encode(titulo, StandardCharsets.UTF_8);
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String json = reader.lines().collect(Collectors.joining());

            ApiResponse respuesta = conversor.obtenerDatos(json, ApiResponse.class);

            if (respuesta.getLibros().isEmpty())
                return null;

            LibroJson lj = respuesta.getLibros().get(0);
            AuthorJson aj = lj.getAuthors().get(0);
            String idioma = lj.getLanguages().get(0);

            Author autor = new Author();
            autor.setName(aj.getName());
            autor.setBirthYear(aj.getBirth_year());
            autor.setDeathYear(aj.getDeath_year());
            autor = authorRepo.save(autor);

            Libro libro = new Libro();
            libro.setGutenbergId(lj.getId());
            libro.setTitle(lj.getTitle());
            libro.setLanguage(idioma);
            libro.setDownloads(lj.getDownload_count());
            libro.setAuthor(autor);

            return bookRepo.save(libro);

        } catch (Exception e) {
            throw new RuntimeException("Error al buscar libro: " + e.getMessage(), e);
        }
    }

    public List<Libro> listarLibros() {
        return bookRepo.findAll();
    }

    public List<Libro> listarPorIdioma(String lang) {
        return bookRepo.findByLanguage(lang);
    }

    public List<Author> listarAutores() {
        return authorRepo.findAll();
    }

    public List<Author> listarAutoresVivos(Integer year) {
        return authorRepo.findByBirthYearBeforeAndDeathYearAfter(year, year);
    }

    public Map<String, Long> estadisticasIdioma(List<String> langs) {
        return bookRepo.findAll().stream()
                .filter(b -> langs.contains(b.getLanguage()))
                .collect(Collectors.groupingBy(Libro::getLanguage, Collectors.counting()));
    }
}
