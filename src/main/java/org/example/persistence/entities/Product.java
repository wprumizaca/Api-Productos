package org.example.persistence.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity //Esta anotación es de JPA
public class Product {

    @Id @GeneratedValue //Te autogenera el valor ID.
    private Long id;

    private String nombre;

    private float precio;
}
