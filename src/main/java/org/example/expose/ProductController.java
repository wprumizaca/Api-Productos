package org.example.expose;

import lombok.RequiredArgsConstructor;
import org.example.persistence.entities.Product;
import org.example.persistence.repositories.ProductRepository;
//import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RequestBody Permite inyectar el cuerpo de la petición en un objeto
// @PathVariable Nos permite inyectar un fragmento de la URL en una variable


//@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    //Si no queremos poner las líneas del contolador usar --> @RequiredArgsConstructor
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Devolver todos los productos

    //@GetMapping("/product")
    public List<Product> productList(){
        return null;
    }

    //Devolver uno específico
    //@GetMapping("/product/{id}")
//    public Product product(@PathVariable Long id){
//        return null;
//    }
}
