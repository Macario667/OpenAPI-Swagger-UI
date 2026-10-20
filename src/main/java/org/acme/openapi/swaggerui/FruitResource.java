package org.acme.openapi.swaggerui;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Frutas", description = "Operaciones para gestionar frutas")
public class FruitResource {

    private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    @Operation(
        summary = "Listar frutas",
        description = "Obtiene todas las frutas registradas."
    )
    @APIResponses({
        @APIResponse(
            responseCode = "200",
            description = "Operación completada"
        ),
        @APIResponse(
            responseCode = "400",
            description = "Solicitud incorrecta"
        ),
        @APIResponse(
            responseCode = "500",
            description = "Error interno del servidor"
        )
    })
    public Set<Fruit> list() {
        return fruits;
    }

    @POST
    @Operation(
        summary = "Agregar fruta",
        description = "Agrega una fruta."
    )
    public Set<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @DELETE
    @Operation(
        summary = "Eliminar fruta",
        description = "Elimina una fruta seleccionada."
    )
    public Set<Fruit> delete(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return fruits;
    }
}
