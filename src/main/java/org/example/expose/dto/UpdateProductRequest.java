package org.example.expose.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateProductRequest {

    private String nombre;
    private Float precio;
    private String categoryId;
}
