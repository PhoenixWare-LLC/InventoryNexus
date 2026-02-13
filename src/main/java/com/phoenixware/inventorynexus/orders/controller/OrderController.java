package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.OrderDTO;
import com.phoenixware.inventorynexus.orders.exception.OrderNotFoundException;
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

    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/{order_id}")
    public OrderDTO getById(@PathVariable("order_id") UUID orderId) {
        return orderService.getOrderById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAll() {
        return orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity create(@RequestBody OrderDTO orderDTO) {
        OrderDTO savedOrder = orderService.saveNewOrder(orderDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/orders/" + savedOrder.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/orders/{order_id}")
    public ResponseEntity putById(@PathVariable("order_id") UUID id, @RequestBody OrderDTO orderDTO) {
        orderService.putById(id, orderDTO);

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @PatchMapping("/orders/{order_id}")
    public OrderDTO patchById(@PathVariable("order_id") UUID orderId, @RequestBody OrderDTO orderDTO) {
        return null;
    }

    @DeleteMapping("/orders/{order_id}")
    public ResponseEntity deleteById() {
        return null;
    }
}
