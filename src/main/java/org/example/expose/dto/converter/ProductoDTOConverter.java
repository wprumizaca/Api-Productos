package org.example.expose.dto.converter;

import lombok.RequiredArgsConstructor;
import org.example.expose.dto.ProductDTOResponse;
import org.example.persistence.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor //@Component -> la clase será un componente de utilidad
public class ProductoDTOConverter { //Esta clase crea un productoDTO a partir de un producto con ayuda de ModelMapper

    private final ModelMapper modelMapper;


    //Va a transformar un producto en un productoDTO
    public ProductDTOResponse convertToDto(Product product){
        return modelMapper.map(product, ProductDTOResponse.class);
                //map recibe el objeto origen(producto) y el tipo de clase destino (ProductDTOResponse)
    }
}
