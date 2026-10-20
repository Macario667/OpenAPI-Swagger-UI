package org.acme.openapi.swaggerui;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Representa una fruta")
public class Fruit {

    @Schema(description = "Nombre de la Fruta", examples = {"Apple"})
    public String name;

    @Schema(description = "Descripción de la fruta", examples = {"Winter fruit"})
    public String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
