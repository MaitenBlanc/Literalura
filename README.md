# Literalura 📚

Aplicación de consola en Java que permite buscar, registrar y consultar libros de dominio público (Gutenberg) y gestionar autores.

## 🔍 Funcionalidades

    - Buscar un libro por título (usa la API de Gutendex).
    - Guardar libros en una base de datos PostgreSQL (o similar).
    - Listar libros y autores registrados.
    - Consultar autores vivos en un año específico.
    - Filtrar libros por idioma.
    - Mostrar el top 10 de libros más descargados.
    - Ver estadísticas generales (total de libros, autores, idiomas, etc.).

## 🚀 Nuevas (Desafío extra)

    - Top 10 libros más descargados desde la BD.
    - Buscar autor por nombre (insensible a mayúsculas).
    - Listar autores nacidos antes de un año dado.
    - Listar autores fallecidos después de un año dado.
    - Estadísticas con DoubleSummaryStatistics, p. ej. edad promedio, mínima y máxima de autores.

## ⚙️ Tecnologías usadas

    - Java 11+
    - Spring Boot
    - Spring Data JPA
    - Jackson (para parseo de JSON de Gutendex)
    - PostgreSQL (compatible con MySQL, MariaDB, SQL Server, H2)
    - Maven

## 🧰 Requisitos previos

    - Java 11 o superior
    - Maven
    - Base de datos SQL (PostgreSQL recomendada)

## 🚀 Setup e instalación

1. Clona el repositorio:
   git clone https://github.com/MaitenBlanc/Literalura.git
   cd Literalura

2. Configura tu base de datos (application.properties):
   spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   spring.jpa.hibernate.ddl-auto=update

3. Instala y ejecuta la BD con Docker (opcional):
   docker-compose up -d

4. Compila y ejecuta la app:
   mvn clean package
   java -jar target/\*.jar

- o con Spring Boot:
  mvn spring-boot:run

## 🎛️ Uso

    Al iniciar, verás un menú similar a este:
        Bienvenido/a a Literalura
        Elige una opción:
        1 - Buscar y guardar libro
        2 - Listar todos los libros
        3 - Listar libros por idioma
        4 - Listar autores
        5 - Listar autores vivos en año
        6 - Estadísticas de idioma
        7 - Top 10 libros más descargados
        8 - Buscar autor por nombre
        9 - Listar autores nacidos antes de un año
        10 - Listar autores fallecidos después de un año
        11 - Mostrar estadísticas edad autores
        0 – Salir

Simplemente introduce el número y sigue las indicaciones.

## 💡 Ejemplos de uso

    - Buscar libro: ingresá un título y se guarda el primer resultado.
    - Top 10: opción 7 → muestra los diez libros con más descargas.
    - Buscar autor: opción 8 → podés buscar por nombre exacto (insensible a mayúsculas).
    - Filtrar autores: opciones 9 y 10 → listan según año de nacimiento/fallecimiento.
    - Estadísticas de edad: opción 11 → muestra edad promedio, mínima y máxima entre los autores con año de nacimiento.

## 🧬 Arquitectura y estructura

    - model: entidades Book, Author.
    - repository: interfaces JPA (BookRepository, AuthorRepository).
    - service: lógica de negocio y comunicación con Gutendex.
    - main: clase principal que arranca la app y controla la interfaz del menú.

## 🛣️ Posibles mejoras futuras

    - API REST para exponer las operaciones.
    - Interfaz web (con Angular o React).
    - Caching de respuestas de Gutendex.
    - Tests unitarios y de integración.
    - Despliegue automático con CI/CD y contenedores Docker.

## 👥 Contribuciones y feedback

Tu feedback es bienvenido! Puedes contribuir mediante issues o pull requests.
Si deseas contactarme: maitengblanc@gmail.com.
