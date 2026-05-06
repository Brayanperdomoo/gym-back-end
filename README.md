# Gym API

Backend para sistema de gimnasio con miembros, entrenadores y sesiones de entrenamiento.

## Tecnologias

- Java 21
- Spring Boot
- PostgreSQL
- Liquibase
- Swagger/OpenAPI
- Docker
- GitHub Actions

## Base de datos local

```sql
CREATE DATABASE gym_db;
```

## Ejecutar localmente

```bash
mvn spring-boot:run
```

## Swagger

```txt
http://localhost:8080/swagger-ui.html
```

## Endpoints

```txt
/api/members
/api/trainers
/api/training-sessions
```

## Validaciones implementadas

- Nombres, apellidos, especialidad y membresia solo aceptan letras y espacios.
- Documento y celular solo aceptan numeros.
- Documento y celular deben tener entre 10 y 12 digitos.
- Correo validado con formato email.
- Duracion de sesion entre 15 y 240 minutos.
- Fecha de sesion no puede estar en el pasado.
