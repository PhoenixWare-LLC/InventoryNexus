package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.OrderDTO;
import com.phoenixware.inventorynexus.orders.mapper.OrderMapper;
import com.phoenixware.inventorynexus.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Service
@Primary
@RequiredArgsConstructor
public class OrderServiceJPA implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderDTO> getUnshippedOrders() {
        return orderRepository.findByShipped(false)
                .stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrderDTO> getOrderById(UUID id) {
        return Optional.ofNullable(orderMapper.orderToOrderDto(orderRepository.findById(id)
                .orElse(null)));
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
