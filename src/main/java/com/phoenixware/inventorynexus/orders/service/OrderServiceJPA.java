package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.order.OrderDTO;
import com.phoenixware.inventorynexus.orders.entity.Order;
import com.phoenixware.inventorynexus.orders.exception.OrderNotFoundException;
import com.phoenixware.inventorynexus.orders.mapper.OrderMapper;
import com.phoenixware.inventorynexus.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
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

    private final JsonMapper jsonMapper;
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
    public OrderDTO getOrderById(UUID id) {
        return orderMapper.orderToOrderDto(
                orderRepository.findById(id).orElseThrow(
                        OrderNotFoundException::new
                )
        );
    }

    @Override
    public OrderDTO patchOrderById(UUID orderId, OrderDTO orderDTO) {
        Order currentOrder = orderRepository.findById(orderId).orElseThrow(
                OrderNotFoundException::new
        );

        Order updatedOrder = orderMapper.updateOrderFromOrderDTO(orderDTO, currentOrder);

        orderRepository.save(updatedOrder);

        return orderMapper.orderToOrderDto(updatedOrder);
    }

    @Override
    public void deleteById(UUID orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new OrderNotFoundException();
        }
    }

    @Override
    public OrderDTO putById(UUID orderId, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(orderId).orElseThrow(
                OrderNotFoundException::new
        );

        if (existingOrder.isFulfilled() || existingOrder.isShipped()) {
            throw new IllegalStateException("Cannot update a shipped/fulfilled order");
        }

        Order updatedOrder = orderMapper.orderDtoToOrder(orderDTO);
        updatedOrder.setId(orderId);

        orderRepository.save(updatedOrder);

        Order orderFromDB = orderRepository.findById(orderId).orElseThrow(
                OrderNotFoundException::new
        );

        return orderMapper.orderToOrderDto(orderFromDB);
    }

    @Override
    public OrderDTO saveNewOrder(OrderDTO orderDTO) {
        return orderMapper.orderToOrderDto(orderRepository.save(orderMapper.orderDtoToOrder(orderDTO)));
    }


}
