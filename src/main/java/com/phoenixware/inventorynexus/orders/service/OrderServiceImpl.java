package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.order.OrderDetailedDTO;
import com.phoenixware.inventorynexus.orders.entity.Order;
import com.phoenixware.inventorynexus.orders.exception.order.OrderNotFoundException;
import com.phoenixware.inventorynexus.orders.mapper.OrderMapper;
import com.phoenixware.inventorynexus.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDetailedDTO create(OrderDetailedDTO orderDetailedDTO) {
        return orderMapper.orderToOrderDetailedDto(orderRepository.save(orderMapper.orderDetailedDtoToOrder(orderDetailedDTO)));
    }

    @Override
    public OrderDetailedDTO updateById(UUID id, OrderDetailedDTO orderDetailedDTO) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(
                OrderNotFoundException::new
        );

        if (existingOrder.getFulfilled() || existingOrder.getShipped()) {
            throw new IllegalStateException("Cannot update a shipped/fulfilled order");
        }

        Order updatedOrder = orderMapper.orderDetailedDtoToOrder(orderDetailedDTO);
        updatedOrder.setId(id);

        orderRepository.save(updatedOrder);

        Order orderFromDB = orderRepository.findById(id).orElseThrow(
                OrderNotFoundException::new
        );

        return orderMapper.orderToOrderDetailedDto(orderFromDB);
    }

    @Override
    public OrderDetailedDTO patchById(UUID id, OrderDetailedDTO orderDetailedDTO) {
        Order currentOrder = orderRepository.findById(id).orElseThrow(
                OrderNotFoundException::new
        );

        Order updatedOrder = orderMapper.patchOrderFromOrderDetailedDto(orderDetailedDTO, currentOrder);

        orderRepository.save(updatedOrder);

        Order orderFromDb = orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);

        return orderMapper.orderToOrderDetailedDto(orderFromDb);
    }

    @Override
    public OrderDetailedDTO findById(UUID id) {
        return orderMapper.orderToOrderDetailedDto(
                orderRepository.findById(id).orElseThrow(
                        OrderNotFoundException::new
                )
        );
    }

    @Override
    public List<OrderDetailedDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::orderToOrderDetailedDto)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteById(UUID id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderNotFoundException();
        }
    }

}
