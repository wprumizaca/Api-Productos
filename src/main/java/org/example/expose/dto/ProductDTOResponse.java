package org.example.expose.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTOResponse {

    private String nombre;
    private float precio;
    private String categoriaNombre;
}
