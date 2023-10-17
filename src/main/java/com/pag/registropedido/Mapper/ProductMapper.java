package com.pag.registropedido.Mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.pag.registropedido.Domain.Entity.ProductEntity;
import com.pag.registropedido.Dto.ProductDTO;
import com.pag.registropedido.Controller.Request.*;
import com.pag.registropedido.Controller.Response.ProductResponse;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductRequest toRequest(ProductDTO productDTO);
    ProductResponse toReponse(ProductRequest productRequest);
    ProductResponse toReponse(ProductDTO productDTO);
    ProductDTO toDTO(ProductRequest productRequest);
    ProductDTO toDTO(ProductResponse productResponse);
    ProductDTO toDTO(ProductEntity produto);
    ProductEntity toEntity(ProductDTO productDTO);

}