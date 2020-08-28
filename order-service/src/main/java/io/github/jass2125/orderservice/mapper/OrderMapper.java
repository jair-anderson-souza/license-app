package io.github.jass2125.orderservice.mapper;


import io.github.jass2125.orderservice.model.Order;
import io.github.jass2125.orderservice.model.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDTO(Order order);

}
