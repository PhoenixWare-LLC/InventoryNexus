package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.order.OrderDTO;
import com.phoenixware.inventorynexus.orders.entity.Order;
import com.phoenixware.inventorynexus.orders.exception.OrderNotFoundException;
import com.phoenixware.inventorynexus.orders.mapper.OrderMapper;
import com.phoenixware.inventorynexus.orders.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@ActiveProfiles("dev")
@SpringBootTest
class OrderControllerIT {
    @Autowired
    OrderController orderController;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Test
    @Transactional
    @Rollback
    void putByIdOrderTest() {
        Order order = orderRepository.findAll().get(10);
        OrderDTO orderDTO = orderMapper.orderToOrderDto(order);
        orderDTO.setId(null);
        final String orderName = "UPDATED";
        orderDTO.setName(orderName);

        ResponseEntity responseEntity = orderController.putById(order.getId(), orderDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(202));

        Order updatedOrder = orderRepository.findById(order.getId()).get();
        assertThat(updatedOrder.getName()).isEqualTo(orderName);
    }

    @Rollback
    @Transactional
    @Test
    void saveNewOrderTest() {
        OrderDTO orderDTO = OrderDTO.builder()
                .city("someCity")
                .state("NY")
                .name("Dave Ramsey")
                .marketplace("Amazon")
                .street1("123 Main St")
                .total(BigDecimal.valueOf(69.99))
                .postalCode("99911")
                .build();
        ResponseEntity responseEntity = orderController.create(orderDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID = UUID.fromString(locationUUID[2]);

        Order order = orderRepository.findById(savedUUID).get();
        assertThat(order).isNotNull();
    }

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

    @Test
    @Transactional
    @Rollback
    void patchExistingOrder() {
        Order order = orderRepository.findAll().getFirst();

        OrderDTO patchFields = OrderDTO.builder()
                .name("Sandy Beaches")
                .state("NY")
                .build();

        OrderDTO patchedOrder = orderMapper.orderToOrderDto(orderMapper.updateOrderFromOrderDTO(patchFields, order));

        ResponseEntity<?> responseEntity = orderController.patchById(order.getId(), patchFields);

        assertThat(responseEntity.getBody()).isEqualTo(patchedOrder);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        assertThat(responseEntity.getHeaders().getFirst("Location")).isEqualTo("/orders/" + patchedOrder.getId());
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