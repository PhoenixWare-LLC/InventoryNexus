package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.OrderDTO;
import com.phoenixware.inventorynexus.orders.entity.Order;
import com.phoenixware.inventorynexus.orders.exception.OrderNotFoundException;
import com.phoenixware.inventorynexus.orders.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@SpringBootTest
class OrderControllerIT {
    @Autowired
    OrderController orderController;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void testOrderIdNotFound() {
        assertThrows(OrderNotFoundException.class, () -> {
            orderController.getById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        Order order = orderRepository.findAll().get(0);

        OrderDTO dto = orderController.getById(order.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testListOrders() {
        List<OrderDTO> dtos = orderController.getAll();

        assertThat(dtos.size()).isEqualTo(21);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
        orderRepository.deleteAll();
        List<OrderDTO> dtos = orderController.getAll();

        assertThat(dtos.size()).isEqualTo(0);

    }
}