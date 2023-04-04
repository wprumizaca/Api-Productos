package org.example.expose;

import lombok.RequiredArgsConstructor;
import org.example.persistence.entities.Product;
import org.example.persistence.repositories.ProductRepository;
import org.hibernate.annotations.SQLInsert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    public List<Product> productList(){
//
//        return productRepository.findAll();
//    }
    public ResponseEntity<?> obtenerTodos(){
        List<Product> result = productRepository.findAll();
        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(result);
        }
    }

    //Devolver uno específico
    @GetMapping("/product/{id}")
//    public Product product(@PathVariable Long id){
//        return productRepository.findById(id).orElse(null); //esto puede ser opcional. Entra en juego manejo de errores
//    }
    public ResponseEntity<?>obtenerUno(@PathVariable Long id){
        Product result = productRepository.findById(id).orElse(null);
        if (result == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(result);
        }
    }

    //Crear producto
    @PostMapping("/product")
//    public Product createproduct(@RequestBody Product nuevo){
//        return productRepository.save(nuevo);
//    }
    public ResponseEntity<?>createProduct(@RequestBody Product nuevo){
        Product saved = productRepository.save(nuevo);
//        return  ResponseEntity.created(location).body(saved); location hace referencia a la url que puede consultar el cliente para ver que el producto se ha creado
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    //Modificar producto
    @PutMapping("/product/{id}")
//    public Product modifiedproduct(@RequestBody Product modificar,@PathVariable Long id){
//        if(productRepository.existsById(id)){
//            modificar.setId(id);
//            return productRepository.save(modificar);
//        }else {
//            return null;
//        }
//    }
    public ResponseEntity<?> modifiedProduct(@RequestBody Product modified, @PathVariable Long id){
//       productRepository.findById(id).map();
//OTRA MANERA DE HACERLO
//        if (productRepository.existsById(id)){
//            modified.setId(id);
//            return ResponseEntity.ok(productRepository.save(modified));
//        }else{
//            return  ResponseEntity.notFound().build();
//        }
        return productRepository.findById(id).map(p ->{
            p.setNombre(modified.getNombre());
            p.setPrecio(modified.getPrecio());
            return ResponseEntity.ok(productRepository.save(p));
        }).orElseGet(() ->{
            return ResponseEntity.notFound().build();
        });
    }

    //Borrar un producto
    @DeleteMapping("/product/{id}")
//    public Product deleteproduct(@PathVariable Long id){
//        if(productRepository.existsById(id)){
//            Product product = productRepository.findById(id).get();
//            productRepository.deleteById(id); //Para borrar el producro
//            return product; //para que nos devuelva el producto borrado
//        }else {
//            return null;
//        }
//    }
    public ResponseEntity<?>deletedProduct(@PathVariable Long id){
//        OTRA MANERA DE HACERLO
//        if(productRepository.existsById(id)){
//            productRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//
//        }else {
//            return ResponseEntity.notFound().build();
//        }
        return productRepository.findById(id).map(p ->{
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElseGet(() ->{
            return ResponseEntity.notFound().build();
        });
    }
}
