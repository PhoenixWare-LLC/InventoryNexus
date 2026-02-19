package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.order.OrderDTO;
import com.phoenixware.inventorynexus.orders.dto.order.OrderDetailedDTO;
import com.phoenixware.inventorynexus.orders.entity.Order;
import com.phoenixware.inventorynexus.shared.mapper.BaseProductMapper;
import org.mapstruct.*;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Mapper(uses = BaseProductMapper.class)
public interface OrderMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromOrderDTO(OrderDTO orderDTO, @MappingTarget Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromOrderDetailedDTO(OrderDetailedDTO orderDetailedDTO, @MappingTarget Order order);

    Order orderDetailedDtoToOrder(OrderDetailedDTO orderDetailedDTO);

    OrderDetailedDTO orderToOrderDetailedDto(Order order);

    Order orderDtoToOrder(OrderDTO orderDTO);

    @Mapping(target = "orderItems", ignore = true)
    OrderDTO orderToOrderDto(Order order);
}
