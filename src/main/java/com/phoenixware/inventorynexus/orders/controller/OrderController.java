package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.order.OrderDTO;
import com.phoenixware.inventorynexus.orders.mapper.OrderMapper;
import com.phoenixware.inventorynexus.orders.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
@RestController
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/orders/{order_id}")
    public OrderDTO getById(@PathVariable("order_id") UUID orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAll() {
        return orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity create(@RequestBody OrderDTO orderDTO) {
        OrderDTO savedOrder = orderService.saveNewOrder(orderDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/orders/" + savedOrder.getId().toString());

        ResponseEntity responseEntity = new ResponseEntity<>(
                savedOrder, httpHeaders, HttpStatus.CREATED
        );

        return responseEntity;
    }

    @PutMapping("/orders/{order_id}")
    public ResponseEntity putById(@PathVariable("order_id") UUID id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.putById(id, orderDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/orders/" + updatedOrder.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                updatedOrder, httpHeaders, HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/orders/{order_id}")
    public ResponseEntity patchById(@PathVariable("order_id") UUID orderId, @RequestBody OrderDTO orderDTO) {
        OrderDTO patchedOrder = orderService.patchOrderById(orderId, orderDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/orders/" + patchedOrder.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                patchedOrder,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @DeleteMapping("/orders/{order_id}")
    public ResponseEntity deleteById(@PathVariable("order_id") UUID id) {
        orderService.deleteById(id);

        ResponseEntity responseEntity = new ResponseEntity(
                HttpStatus.NO_CONTENT
        );

        return responseEntity;
    }
}
