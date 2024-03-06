document.addEventListener("DOMContentLoaded", () => {
    const detalleEstudianteDiv = document.getElementById("detalle-estudiante");

    // Obtener el ID del estudiante desde los parámetros de la URL
    const urlParams = new URLSearchParams(window.location.search);
    const estudianteId = urlParams.get("id");

    // Puedes cambiar la URL a la de tu API para obtener detalles del estudiante
    const apiUrl = `http://localhost:8080/estudiantes/${estudianteId}`;

    // Función para cargar detalles del estudiante
    const cargarDetallesEstudiante = () => {
        // Hacer una solicitud GET a la API
        fetch(apiUrl)
            .then(response => response.json())
            .then(estudiante => {
                // Crear un elemento para mostrar los detalles del estudiante
                const detalleEstudiante = document.createElement("div");
                detalleEstudiante.innerHTML = `
                    <p><strong>ID:</strong> ${estudiante.id}</p>
                    <p><strong>Nombre:</strong> ${estudiante.nombre}</p>
                    <p><strong>Apellido:</strong> ${estudiante.apellido}</p>
                    <p><strong>Matrícula:</strong> ${estudiante.matricula}</p>
                    <p><strong>Edad:</strong> ${estudiante.edad}</p>
                    <p><strong>Ciudad:</strong> ${estudiante.ciudad}</p>
                    <!-- Agrega más detalles según sea necesario -->
                `;

                // Agregar el elemento al contenedor en la página
                detalleEstudianteDiv.appendChild(detalleEstudiante);
            })
            .catch(error => console.error("Error al obtener detalles del estudiante:", error));
    };

    // Llamar a la función para cargar detalles del estudiante
    cargarDetallesEstudiante();
});
