package org.example.expose.converter;

import lombok.RequiredArgsConstructor;
import org.example.expose.dto.ProductResponse;
import org.example.expose.dto.SaveProductRequest;
import org.example.expose.dto.UpdateProductRequest;
import org.example.persistence.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor //@Component -> la clase será un componente de utilidad
public class ProductoDTOConverter { //Esta clase crea un productoDTO a partir de un producto con ayuda de ModelMapper

    private final ModelMapper modelMapper;

    //Va a transformar un Product en un productoDTO(ProductResponse)
    public ProductResponse convertToDto(Product product){
        return modelMapper.map(product, ProductResponse.class);
                //map recibe el objeto origen(producto) y el tipo de clase destino (ProductDTOResponse)
    }


    public Product convertToProduct(SaveProductRequest saveProductRequest){
        return modelMapper.map(saveProductRequest, Product.class);
    }



    public Product convertToProductU(UpdateProductRequest updateProductRequest){
        return modelMapper.map(updateProductRequest, Product.class);
    }
}
