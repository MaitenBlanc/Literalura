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
        1 – Buscar libro por título
        2 – Listar libros registrados
        3 – Listar autores registrados
        4 – Listar autores vivos en un año específico
        5 – Listar libros por idioma
        6 – Top 10 libros más descargados
        7 – Estadísticas generales
        0 – Salir
    Simplemente introduce el número y sigue las indicaciones.

## 💡 Ejemplos de uso

    - Buscar y guardar un libro: selecciona opción 1 y escribe el título o parte de él.
    - Listar autores vivos en 1900: opción 4 → ingresa "1900".
    - Ver top 10: opción 6 despliega los libros con mayor cantidad de descargas.

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
