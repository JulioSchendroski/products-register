package com.pag.registropedido.Mapper;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.pag.registropedido.Controller.Request.OrderRequest;
import com.pag.registropedido.Controller.Response.OrderResponse;
import com.pag.registropedido.Domain.Entity.OrderEntity;
import com.pag.registropedido.Dto.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderMapping {

    OrderMapping INSTANCE = Mappers.getMapper(OrderMapping.class);

    OrderDTO toDTO(OrderEntity orderEntity);
    OrderEntity toEntity(OrderDTO orderDTO);
    OrderResponse toResponse(OrderRequest orderRequest);
    OrderEntity toEntity(Optional<OrderEntity> ordenEntityOptiional);
    OrderResponse toResponse(OrderEntity orderEntity);

}
