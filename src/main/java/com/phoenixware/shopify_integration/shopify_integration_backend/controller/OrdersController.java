package com.phoenixware.shopify_integration.shopify_integration_backend.controller;

import com.phoenixware.shopify_integration.shopify_integration_backend.dto.BatchOrderResponse;
import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;
import com.phoenixware.shopify_integration.shopify_integration_backend.exception.OrderNotFoundException;
import com.phoenixware.shopify_integration.shopify_integration_backend.service.OrderService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class OrdersController {

    private final OrderService orderService;
    private final JsonMapper jsonMapper;

    public OrdersController(OrderService orderService, JsonMapper jsonMapper) {
        this.orderService = orderService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getAll();
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        Order order = orderService.getOrder(orderId);
        if (order == null) {
            throw new OrderNotFoundException("Order id not found - " + orderId);
        }
        return order;
    }

    @PostMapping("/orders")
    public Order commitOrder(@RequestBody Order order) {
        order.setId(0);

        Order dbOrder = orderService.commit(order);

        return dbOrder;
    }

    @PostMapping("/orders/batch")
    public BatchOrderResponse commitOrder(@RequestBody List<Order> orders) {
        Objects.requireNonNull(orders, "Request Body cannot be null!");
        List<Order> successfulOrders = new ArrayList<>();
        List<Order> unsuccessfulOrders = new ArrayList<>();

        // TODO: make the commit order here see if we have an order with the same name, amount order date etc, and run an update on that order if so.
        for (Order order : orders) {
            order.setId(0);
            Order dbOrder = orderService.commit(order);

            if (dbOrder == null) {
                unsuccessfulOrders.add(order);
            } else {
                successfulOrders.add(order);
            }

        }

        BatchOrderResponse batchOrderResponse = new BatchOrderResponse(successfulOrders.size(), unsuccessfulOrders.size(), successfulOrders, unsuccessfulOrders);

        return batchOrderResponse;
    }

    @PutMapping("/orders")
    public Order update(@RequestBody Order order) {
        return orderService.commit(order);
    }

    @PatchMapping("/orders/{orderId}")
    public Order patch(@PathVariable int orderId, @RequestBody Map<String, Object> patchPayload) {
        Order tempOrder = orderService.getOrder(orderId);

        if (tempOrder == null) {
            throw new OrderNotFoundException("Order Id not found - " + orderId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Order Id not allowed in request body - " + orderId);
        }

        Order patchedOrder = jsonMapper.updateValue(tempOrder, patchPayload);

        Order dbOrder = orderService.commit(patchedOrder);

        return dbOrder;
    }

    @DeleteMapping("/orders/{orderId}")
    public String deleteById(@PathVariable int orderId) {
        Order order = orderService.getOrder(orderId);

        if (order == null) {
            throw new OrderNotFoundException("Order id not found - " + orderId);
        }

        orderService.deleteById(orderId);

        return "Deleted order id - " + orderId;
    }


}
