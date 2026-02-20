package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.order.OrderDetailedDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface OrderService {
    List<OrderDetailedDTO> getUnshippedOrders();

    List<OrderDetailedDTO> getAllOrders();

    OrderDetailedDTO getOrderById(UUID id);

    OrderDetailedDTO patchOrderById(UUID orderId, OrderDetailedDTO orderDetailedDTO);

    void deleteById(UUID orderId);

    OrderDetailedDTO putById(UUID orderId, OrderDetailedDTO orderDetailedDTO);

    OrderDetailedDTO saveNewOrder(OrderDetailedDTO orderDetailedDTO);


}
