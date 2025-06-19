package com.aluracursos.literalura;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.service.GutendexService;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private GutendexService service;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			mostrarMenu();
			int opts = sc.nextInt();
			sc.nextLine();
			try {
				switch (opts) {
					case 1:
						System.out.print("Título a buscar: ");
						String t = sc.nextLine();
						Libro b = service.buscarYGuardarLibro(t);
						System.out.println(b != null ? "Guardado: " + b : "No se encontró.");
						break;
					case 2:
						service.listarLibros().forEach(System.out::println);
						break;
					case 3:
						System.out.print("Idioma: ");
						service.listarPorIdioma(sc.nextLine()).forEach(System.out::println);
						break;
					case 4:
						service.listarAutores().forEach(System.out::println);
						break;
					case 5:
						System.out.print("Año para vivos: ");
						service.listarAutoresVivos(sc.nextInt()).forEach(System.out::println);
						break;
					case 6:
						System.out.print("Idioma 1: ");
						String l1 = sc.nextLine();
						System.out.print("Idioma 2: ");
						String l2 = sc.nextLine();
						Map<String, Long> stats = service.estadisticasIdioma(Arrays.asList(l1, l2));
						stats.forEach((lang, count) -> System.out.println(lang + " -> " + count));
						break;
					case 7:
						service.obtenerTop10LibrosMasDescargados()
								.forEach(System.out::println);
						break;
					case 8:
						System.out.print("Nombre autor: ");
						String nombreAutor = sc.nextLine();
						var autor = service.buscarAutorPorNombre(nombreAutor);
						if (autor != null)
							System.out.println(autor);
						else
							System.out.println("Autor no encontrado");
						break;
					case 9:
						System.out.print("Año límite: ");
						int anioNacimiento = sc.nextInt();
						sc.nextLine();
						service.listarAutoresNacidosAntesDe(anioNacimiento)
								.forEach(System.out::println);
						break;
					case 10:
						System.out.print("Año límite: ");
						int anioFallecimiento = sc.nextInt();
						sc.nextLine();
						service.listarAutoresFallecidosDespuesDe(anioFallecimiento)
								.forEach(System.out::println);
						break;
					case 11:
						service.mostrarEstadisticasEdadAutores();
						break;
					case 0:
						System.out.println("Saliendo...");
						sc.close();
						return;
					default:
						System.out.println("Opción inválida");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private void mostrarMenu() {
		System.out.println("\n==== Menú Literalura ====");
		System.out.println("1) Buscar y guardar libro");
		System.out.println("2) Listar todos los libros");
		System.out.println("3) Listar libros por idioma");
		System.out.println("4) Listar autores");
		System.out.println("5) Listar autores vivos en año");
		System.out.println("6) Estadísticas de idioma");
		System.out.println("7) Top 10 libros más descargados");
		System.out.println("8) Buscar autor por nombre");
		System.out.println("9) Listar autores nacidos antes de un año");
		System.out.println("10) Listar autores fallecidos después de un año");
		System.out.println("11) Mostrar estadísticas edad autores");
		System.out.println("0) Salir");
		System.out.print("Opción: ");
	}
}
