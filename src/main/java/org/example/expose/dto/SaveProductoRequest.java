package org.example.expose.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaveProductoRequest {

    private String nombre;
    private float precio;
    private long categoryId; //rescatamos id de category para despues sacar el nombre concreto
}
