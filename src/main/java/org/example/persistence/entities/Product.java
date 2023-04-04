package org.example.persistence.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity //Esta anotación es de JPA
public class Product {

    @Id @GeneratedValue //Te autogenera el valor ID.
    private Long id;

    //@Column(name="name") Poner el nombre que queremos que tenga esta columna en la base de datos
    private String nombre;

    private float precio;
}
