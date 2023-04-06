package org.example.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity //Esta anotación es de JPA
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Te autogenera el valor ID.
    private Long id;

    //@Column(name="name") Poner el nombre que queremos que tenga esta columna en la base de datos
    private String nombre;

    private float precio;

    //Relacion de muchos a uno. La entidad que tiene 1 pasa a la entidad que tiene muchos, en este caso muchos en Product
    @ManyToOne
    @JoinColumn(name="categoria_id") //categoria_id será el nombre de la columna en la tabla product.
    private Category category;
}
