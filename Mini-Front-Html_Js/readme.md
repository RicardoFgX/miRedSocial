# Consumir API de Estudiantes - Mini Front-End

Este mini front-end está diseñado para consumir una API de estudiantes y mostrar la información en una interfaz web simple. Utiliza HTML, Bootstrap y JavaScript para interactuar con la API.

## Instrucciones de Uso

1. **Cargar Estudiantes:**
   - Al hacer clic en el botón "Cargar Estudiantes", se realiza una solicitud a la API para obtener una lista de estudiantes.
   - Los datos se presentan en una tabla con las columnas ID, Nombre, Apellido y Matrícula.

2. **Detalles del Estudiante:**
   - Al hacer clic en una fila de la tabla, se redirige a una nueva página (`detalleEstudiante.html`) con detalles específicos del estudiante seleccionado.

3. **Navegación de Páginas:**
   - Puedes navegar entre las páginas de estudiantes utilizando los botones "Página Anterior" y "Siguiente Página".
   - Los botones se ocultan automáticamente si no hay páginas anteriores o siguientes disponibles.

## Configuración
- La URL de la API está configurada en la variable `apiUrl` en el archivo `app.js`. Asegúrate de que coincide con la ubicación de tu API.

## Requisitos
- Conexión a Internet para cargar la API.

## Tecnologías Utilizadas
- HTML
- Bootstrap (CSS y JS)
- JavaScript

## Autor
- Ricardo Fernandez Guzman

¡Espero que encuentres útil este mini front-end para consumir tu API de estudiantes!
