package org.example.expose.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private String nombre;
    private float precio;

    //category hace referencia al nombre de la entidad, que en este caso es la clase Category
    private String categoryNombre;

}
