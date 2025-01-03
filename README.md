Enciclopedia de Personajes de Marvel

Este proyecto es una Enciclopedia de Personajes de Marvel que permite buscar información sobre personajes del universo Marvel utilizando la API de Marvel Developer. La aplicación utiliza Java para el backend y HTML, CSS, y JavaScript para el frontend.

Características

Buscar personajes por nombre.

Mostrar detalles del personaje, incluyendo:

Nombre.

Descripción.

Imagen.

Cómics relacionados.

Diseño responsivo y atractivo.

Tecnologías Utilizadas

Backend

Java (Spring Boot)

RestTemplate para consumir la API de Marvel.

Configuración de CORS para permitir solicitudes desde el frontend.

Frontend

HTML5 y CSS3 para el diseño.

JavaScript para la interacción y solicitudes al backend.

API

Marvel Developer API para obtener los datos de los personajes.

Requisitos Previos

Clave Pública y Privada de la API de Marvel:

Crea una cuenta en Marvel Developer.

Genera tu clave pública y privada.

Java:

Instala Java 11 o superior.

Node.js (opcional para el frontend, si usas herramientas como Live Server).

Cómo Ejecutar el Proyecto

Backend

Clona el repositorio:

git clone https://github.com/tu-usuario/enciclopedia-marvel.git

Ve al directorio del backend:

cd enciclopedia-marvel/backend

Configura las claves de la API de Marvel en el archivo ControllerPersonaje.java

marvel.api.publicKey=TU_CLAVE_PUBLICA
marvel.api.privateKey=TU_CLAVE_PRIVADA

Inicia el servidor:

./mvnw spring-boot:run

El backend estará disponible en: http://localhost:8080

Frontend

Ve al directorio del frontend:

cd enciclopedia-marvel/frontend

Abre el archivo index.html en tu navegador o utiliza una herramienta como Live Server para ejecutarlo:

npx live-server

El frontend estará disponible en: http://127.0.0.1:5500

Autor

Desarrollado por Stelian.


![image](https://github.com/user-attachments/assets/efbfe1ad-5e01-4921-bff9-d4bbe737ec55)


