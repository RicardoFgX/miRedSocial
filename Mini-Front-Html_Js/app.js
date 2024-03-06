document.addEventListener("DOMContentLoaded", () => {
    const estudiantesList = document.getElementById("estudiantes-list");
    const loadEstudiantesBtn = document.getElementById("loadEstudiantesBtn");
    const nextPageBtn = document.getElementById("nextPageBtn");
    const prevPageBtn = document.getElementById("prevPageBtn");

    let pageNumber = 0;
    let currentPage = 0;
    let apiUrl = `http://localhost:8080/estudiantes?page=${pageNumber}`;

    const loadEstudiantes = () => {
        estudiantesList.innerHTML = "";

        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                data.content.forEach(estudiante => {
                    const listItem = document.createElement("tr");
                    listItem.innerHTML = `<td>${estudiante.id}</td><td>${estudiante.nombre}</td><td>${estudiante.apellido}</td><td>${estudiante.matricula}</td>`;
                    
                    listItem.addEventListener("click", () => {
                        window.location.href = `detalleEstudiante.html?id=${estudiante.id}`;
                    });

                    estudiantesList.appendChild(listItem);
                });

                currentPage = data.number;


            })
            .catch(error => {
                console.error("Error al obtener datos de la API:", error);
            });
    };

    const loadNextPage = () => {
        currentPage++;
        const nextPageUrl = `http://localhost:8080/estudiantes?page=${currentPage}`;
        apiUrl = nextPageUrl;
        loadEstudiantes();
    };

    const loadPrevPage = () => {
        if (currentPage > 0) {
            currentPage--;
            const prevPageUrl = `http://localhost:8080/estudiantes?page=${currentPage}`;
            apiUrl = prevPageUrl;
            loadEstudiantes();
        }
    };

    loadEstudiantesBtn.addEventListener("click", loadEstudiantes);
    nextPageBtn.addEventListener("click", loadNextPage);
    prevPageBtn.addEventListener("click", loadPrevPage);
});
