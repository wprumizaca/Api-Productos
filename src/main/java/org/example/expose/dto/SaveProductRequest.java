package org.example.expose.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaveProductRequest {

    private String nombre;
    private float precio;


    private long categoryId; //rescatamos id de category para despues sacar el nombre concreto.
    // IMPORTANTE! Cuando usamos DTOs en la llamada tenemos que poner el nombre que tiene la variables AQUI.
}
