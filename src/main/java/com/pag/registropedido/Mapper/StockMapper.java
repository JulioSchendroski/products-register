package com.pag.registropedido.Mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.pag.registropedido.Controller.Request.StockRequest;
import com.pag.registropedido.Controller.Response.StockResponse;
import com.pag.registropedido.Domain.Entity.StockEntity;
import com.pag.registropedido.Dto.ProductDTO;
import com.pag.registropedido.Dto.StockDTO;

@Mapper(componentModel = "spring")
public interface StockMapper {
    
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    StockDTO toDTO(StockEntity stock);
    StockEntity toEntity(StockDTO stockDto);
    StockRequest toRequest(StockDTO stockDto);
    StockResponse toResponse(ProductDTO productDto);
    StockResponse toResponse(StockDTO stockDTO);


}