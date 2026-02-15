package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.OrderItemDTO;
import com.phoenixware.inventorynexus.orders.entity.OrderItem;
import com.phoenixware.inventorynexus.shared.mapper.BaseProductMapper;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Mapper(uses = BaseProductMapper .class)
public interface OrderItemMapper {

    OrderItem orderItemDtoToOrderItem(OrderItemDTO orderItemDTO);

    OrderItemDTO orderItemToOrderItemDto(OrderItem orderItem);
}
