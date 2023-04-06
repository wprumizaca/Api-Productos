package org.example.persistence.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity //Esta anotación es de JPA
public class Product {

    @Id @GeneratedValue //Te autogenera el valor ID.
    private Long id;

    //@Column(name="name") Poner el nombre que queremos que tenga esta columna en la base de datos
    private String nombre;

    private float precio;

    //Relacion de muchos a uno. La entidad que tiene 1 pasa a la entidad que tiene muchos, en este caso muchos en Product
    @ManyToOne
    @JoinColumn(name="categoria_id", nullable = false)
    private Category category;
}
