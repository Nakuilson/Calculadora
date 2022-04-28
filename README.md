# Calculadora API

API para proyecto calculadora.

### librerias
- Spring Boot 2.5.7
    - spring-boot-starter-web
    - spring-boot-starter-actuator
    - spring-boot-starter-test
    - spring-boot-maven-plugin

- openapi- generator
  OpenAPI Generator permite la generación de bibliotecas de clientes API (generación SDK), stubs de servidor, documentación y configuración automáticamente dada una especificación OpenAPI (v2, v3).
- Tracer
  Libreria suministrada para la prueba, para las trazas.
### 🔧 Instalación

Para ejecutar y desarrollar sobre este servicio debe contar con los siguientes requisitos:
- [OpenJDK 11](https://adoptopenjdk.net/installation.html#installers)
- [Maven 3.8.3](https://archive.apache.org/dist/maven/maven-3/3.8.3/binaries/).

Run `mvn clean verify` para el chequeo.

Para instalar la libreria tracer en el repositorio de maven local

```
mvn install:install-file -Dfile=C:{rutafichero}\tracer-1.0.0.jar -DgroupId=io.corp -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar
````

### Ejecución

Para arrancar en local
```
cd calculadora
mvn spring-boot:run
```
Una vez arrancado el microservicio se puede chequear con actuator
```
http://localhost:8083/actuator/health
```

### ⚙️ Local testing
Se pueden lanzar los test desde consola cmd
```
mvn test
```
Pruebas desde Postman

http://localhost:8080/operaciones/suma/{num1}/{num2}

http://localhost:8080/operaciones/resta/{num1}/{num2}

Siendo num1 y num2 , dos números enteros.

Pruebas desde Swagger

http://localhost:8080/swagger-ui/index.html

 

