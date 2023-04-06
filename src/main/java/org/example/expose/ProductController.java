package org.example.expose;

import lombok.RequiredArgsConstructor;
import org.example.expose.dto.ProductResponse;
import org.example.expose.dto.SaveProductRequest;
import org.example.expose.converter.ProductoDTOConverter;
import org.example.expose.dto.UpdateProductRequest;
import org.example.persistence.entities.Product;
import org.example.persistence.repositories.CategoryRepository;
import org.example.persistence.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    //Creamo objeto del componente de utilidad para poder hacer la transformación de producto a productDTO
    private final ProductoDTOConverter productoDTOConverter;


    //Devolver todos los productos y el nombre de la categoria
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
            List<ProductResponse> dtoResult = result.stream()
                    .map(productoDTOConverter::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoResult);
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
            ProductResponse dtoResult = productoDTOConverter.convertToDto(result);
            return ResponseEntity.ok(dtoResult);
        }
    }

    //Crear producto
    @PostMapping("/product")
//    public Product createproduct(@RequestBody Product nuevo){
//        return productRepository.save(nuevo);
//    }
//    public ResponseEntity<?>createProduct(@RequestBody Product nuevo){
//        Product saved = productRepository.save(nuevo);
////        return  ResponseEntity.created(location).body(saved); location hace referencia a la url que puede consultar el cliente para ver que el producto se ha creado
//        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
//    }

    public ResponseEntity<?>createProduct(@RequestBody SaveProductRequest nuevo){

        //Lo primero que hacemos es pasar el DTO a una entidad. Después guardamos los datos de esa entidad.
       Product product = productoDTOConverter.convertToProduct(nuevo);

       return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));


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
    public ResponseEntity<?> modifiedProduct(@RequestBody UpdateProductRequest modified, @PathVariable Long id){
//OTRA MANERA DE HACERLO
//        if (productRepository.existsById(id)){
//            modified.setId(id);
//            return ResponseEntity.ok(productRepository.save(modified));
//        }else{
//            return  ResponseEntity.notFound().build();
//        }
//        return productRepository.findById(id).map(p ->{
//            p.setNombre(modified.getNombre());
//            p.setPrecio(modified.getPrecio());
//            return ResponseEntity.ok(productRepository.save(p));
//        }).orElseGet(() ->{
//            return ResponseEntity.notFound().build();
//        });
        if (productRepository.existsById(id)){
            Product product = productoDTOConverter.convertToProductU(modified);
            product.setId(id);
            return ResponseEntity.ok(productRepository.save(product));
        }else{
            return  ResponseEntity.notFound().build();
        }
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
