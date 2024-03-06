# Proyecto Red Social - Backend

Este proyecto es una aplicación de red social desarrollada con el framework Spring. Proporciona una plataforma para gestionar usuarios, clases y estudiantes.

## Funcionalidades Principales

1. **Usuarios:**
   - Registro y autenticación de usuarios.
   - Gestión de información de usuario.

2. **Estudiantes:**
   - Gestión de información de estudiantes.
   - Paginación y filtrado de estudiantes.

3. **Seguridad:**
   - Implementación de autenticación y autorización con Spring Security.
   - Generación y validación de tokens JWT.

- **Otras funciones implementadas:**
   - Se ha implementado un sistema de paginado
   - Se ha implementado los métodos para llevar a cabo el filtrado, en la clase [EstudianteServiceImpl](/src/main/java/com/proyectoredsocial/miRedSocial/servicesImpl/EstudianteServiceImpl.java)
   - Se ha realizado los [test](/src/test/) a diferentes métodos de la aplicación 
   - Se han realizado diferentes pruebas con PostMan, recogidas en el siguiente [Json](/Postman/app-API.postman_collection.json)
   - Se ha generado la [documentación](/doc/)
   - Se ha elaborado un pequeño [front](/Mini-Front-Html_Js/) para consumir funciones muy sencillas de la API

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- JWT para autenticación

## Estructura del Proyecto

- `src/main/java/com/proyectoredsocial/miRedSocial`: Contiene los archivos fuente Java.
- `src/main/resources`: Contiene archivos de configuración y scripts SQL.
- `Mini-Front-Html_Js`: Contiene el frontend desarrollado con HTML y JavaScript.

## Configuración

1. Configura la base de datos en `application.properties` con tu URL, usuario y contraseña.
2. Tener una base de datos con el nombre utilizado en `application.properties`, en este caso se llama ***dbEjemplo***

## Ejecución del Proyecto

1. Clona el repositorio.
2. Abre el proyecto en tu IDE favorito.
3. Ejecuta la clase principal `MiRedSocialApplication` para iniciar la aplicación.

## Ejecución del Frontend

1. Abre la carpeta `Mini-Front-Html_Js` en tu explorador de archivos.
2. Ejecuta el archivo `index.html` en tu navegador web.

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras algún problema o tienes sugerencias, por favor abre un issue o envía un pull request.

## Autor

- Ricardo Fernandez Guzman
