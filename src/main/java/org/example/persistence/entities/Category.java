package org.example.persistence.entities;

import lombok.Data;

import javax.persistence.*;


@Data //contiene anotaciones como @getters, @setters, @tostring, etc
@Entity //Para indicar que esta clase persistente es una entidad
@Table(name = "category")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//clave primaria y valor-autogenerado
    private Long id;

    private String nombre;

//    @OneToMany(mappedBy = "category")
//    private List<Product> items;



}
