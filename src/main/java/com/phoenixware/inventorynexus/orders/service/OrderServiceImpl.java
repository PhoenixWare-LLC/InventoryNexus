package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<OrderDTO> getUnshippedOrders() {
        return List.of();
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return List.of();
    }

    @Override
    public Optional<OrderDTO> getOrderById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void patchOrderById(UUID orderId, OrderDTO orderDTO) {

    }

    @Override
    public void deleteById(UUID orderId) {

    }

    @Override
    public void putById(UUID orderId) {

    }

    @Override
    public OrderDTO saveNewOrder(OrderDTO orderDTO) {
        return null;
    }
}
