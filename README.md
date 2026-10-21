# openapi-swaggerui-quickstart

API JSON en memoria que muestra cómo documentar operaciones con OpenAPI y explorarlas desde Swagger UI.

## Guías adaptadas

- [Using OpenAPI and Swagger UI](https://quarkus.io/guides/openapi-swaggerui): extensión `quarkus-smallrye-openapi`, anotaciones en los endpoints, especificación YAML y configuración de Swagger UI.
- [Writing JSON REST Services](https://quarkus.io/guides/rest-json): `quarkus-rest-jackson` recibe y devuelve objetos JSON.
- [Conocimientos JSON](https://www.nylas.com/blog/the-complete-guide-to-working-with-json/): conceptos para entender los cuerpos y las respuestas de la API.

La guía [RESTEasy Classic](https://es.quarkus.io/guides/resteasy) no describe las extensiones de este proyecto: utiliza Quarkus REST (`quarkus-rest-jackson`).

## Cómo se aplica

- `FruitResource` expone `GET`, `POST` y `DELETE` en `/fruits`.
- `@Tag`, `@Operation`, `@APIResponse` y `@APIResponses` agregan metadatos a la documentación generada.
- `META-INF/openapi.yaml` aporta una descripción OpenAPI complementaria.
- `application.properties` configura el título, la ruta `/openapi` y Swagger UI en `/swagger-ui`.
- Los datos se conservan solo en memoria; al reiniciar se restauran las frutas iniciales.

## Ejecutar y explorar

Requiere Java 17 según `maven.compiler.release` en `pom.xml`.

```powershell
.\mvnw.cmd quarkus:dev
```

Abre `http://localhost:8080/swagger-ui` en el navegador. La especificación está en `http://localhost:8080/openapi`. También puedes consultar la API desde PowerShell:

```powershell
curl.exe http://localhost:8080/fruits
curl.exe -i -X POST http://localhost:8080/fruits `
  -H "Content-Type: application/json" `
  -d '{"name":"Mango","description":"Fruta tropical"}'
curl.exe -i -X DELETE http://localhost:8080/fruits `
  -H "Content-Type: application/json" `
  -d '{"name":"Mango","description":"Fruta tropical"}'
```

## Ejercicio para explicar OpenAPI

1. Agrega una anotación `@Operation` a un endpoint y describe qué verá el consumidor.
2. Añade o ajusta una respuesta `@APIResponse`.
3. Vuelve a cargar Swagger UI y localiza el cambio.
4. Compara la documentación generada a partir de anotaciones con el fragmento manual de `openapi.yaml`.

Ejecuta las pruebas con `.\mvnw.cmd test`.
