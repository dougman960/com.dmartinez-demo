<p align="left">
   <img src="https://img.shields.io/badge/STATUS-EN%20FINISHED-green">
</p>

# service-dmartinez-demo

  Proyecto creado con spring boot 4 y documentado con swagger 

## <a name="caracteristicas"></a> 📎 Características técnicas:

| Seccion                        | Descripcion                                                                                                                                                 |
|--------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Estructura del proyecto**    | Estructura del proyecto organizada siguiendo las mejores prácticas y convenciones para mejorar la legibilidad y facilidad de mantenimiento del código.      |
| **DTOs**                       | Uso de DTO para encapsular datos                                                                                                                            |
| **Capa de repositorio**        | Lógica de acceso a datos administrada por repositorios JPA, aprovechando Spring Data JPA para interacciones fluidas con bases de datos.                     |
| **Capa de servicio**           | 	Lógica empresarial encapsulada en clases de servicio para mantener la separación de preocupaciones y mejorar la modularidad.                               |
| **MVC Arquitectura**           |Implementación del patrón arquitectónico Modelo-Vista-Controlador para organizar y gestionar los componentes de la aplicación.                               |
| **Manejo de excepciones**      | Manejo de excepciones personalizado para gestionar errores de forma elegante y proporcionar respuestas significativas a los clientes.                       |
| **Interacción con la BD**      | Interacción con la base de datos MySQL utilizando Hibernate como implementación de JPA, garantizando el almacenamiento y recuperación eficiente de datos.   |

## ✔️ tecnologías-utilizadas
- Java 8
- H2 DATA BASE
- Spring Boot
- Maven
- Swagger
- Lombok
  
## :hammer:Funcionalidad del proyecto

-  servicio para consultar ofertas

## 🛠️ URLS DE ACCESOS
- Swagger : http://localhost:6025/swagger-ui.html
- Base de datos :
                 - url: http://localhost:6025/h2-console/
                 - jdbc: jdbc:h2:mem:testdb
                 - usuario: sa
                 - password: password
