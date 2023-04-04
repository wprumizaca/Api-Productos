package org.example.expose;

import lombok.RequiredArgsConstructor;
import org.example.persistence.entities.Product;
import org.example.persistence.repositories.ProductRepository;
import org.hibernate.annotations.SQLInsert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RequestBody Permite inyectar el cuerpo de la petición en un objeto
// @PathVariable Nos permite inyectar un fragmento de la URL en una variable


@RestController //hace la conversion de lo que da el objeto a lo que verá el cliente (json, xml, etc)

//@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    //Si no queremos poner las líneas del contolador usar --> @RequiredArgsConstructor
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //Devolver todos los productos
    @GetMapping("/product")
    public List<Product> productList(){

        return productRepository.findAll();
    }


    //Devolver uno específico
    @GetMapping("/product/{id}")
    public Product product(@PathVariable Long id){
        return productRepository.findById(id).orElse(null); //esto puede ser opcional. Entra en juego manejo de errores
    }

    //Crear producto
    @PostMapping("/product")
    public Product createproduct(@RequestBody Product nuevo){
        return productRepository.save(nuevo);
    }

    //Modificar producto
    @PutMapping("/product/{id}")
    public Product modifiedproduct(@RequestBody Product modificar,@PathVariable Long id){
        if(productRepository.existsById(id)){
            modificar.setId(id);
            return productRepository.save(modificar);
        }else {
            return null;
        }
    }

    //Borrar un producto
    @DeleteMapping("/product/{id}")
    public Product deleteproduct(@PathVariable Long id){
        if(productRepository.existsById(id)){
            Product product = productRepository.findById(id).get();
            productRepository.deleteById(id); //Para borrar el producro
            return product; //para que nos devuelva el producto borrado
        }else {
            return null;
        }

    }
}
