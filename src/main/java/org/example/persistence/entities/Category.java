package org.example.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data //contiene anotaciones como @getters, @setters, @tostring, etc
@Entity //Para indicar que esta clase persistente es una entidad
public class Category {

    @Id @GeneratedValue //clave primaria y valor-autogenerado
    private Long id;

    private String nombre;
}
