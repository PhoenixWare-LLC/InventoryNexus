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
    Order orderDtoToOrder(OrderDTO orderDTO);
    Order orderDetailedDtoToOrder(OrderDetailedDTO orderDetailedDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order patchOrderFromOrderDetailedDto(OrderDetailedDTO orderDetailedDTO, @MappingTarget Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order patchOrderFromOrderDTO(OrderDTO orderDTO, @MappingTarget Order order);

    OrderDTO orderToOrderDto(Order order);
    OrderDetailedDTO orderToOrderDetailedDto(Order order);


}
