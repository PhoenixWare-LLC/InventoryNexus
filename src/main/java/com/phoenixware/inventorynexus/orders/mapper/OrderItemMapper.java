package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.orderitem.OrderItemDTO;
import com.phoenixware.inventorynexus.orders.dto.orderitem.OrderItemDetailedDTO;
import com.phoenixware.inventorynexus.orders.entity.OrderItem;
import com.phoenixware.inventorynexus.shared.mapper.BaseProductMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Mapper(uses = BaseProductMapper .class)
public interface OrderItemMapper {

    OrderItem orderItemDtoToOrderItem(OrderItemDTO orderItemDTO);
    OrderItem orderItemDetailedDtoToOrderItem(OrderItemDetailedDTO orderItemDetailedDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderItem patchOrderItemFromOrderItemDto(OrderItemDTO orderItemDTO, @MappingTarget OrderItem orderItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderItemDTO patchOrderItemDtoFromOrderItem(OrderItem orderItem, @MappingTarget OrderItemDTO orderItemDTO);

    OrderItemDTO orderItemToOrderItemDto(OrderItem orderItem);
    OrderItemDetailedDTO orderItemToOrderItemDetailedDto(OrderItem orderItem);
}
