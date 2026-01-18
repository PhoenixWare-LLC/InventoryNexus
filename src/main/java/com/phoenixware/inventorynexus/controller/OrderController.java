package com.phoenixware.inventorynexus.controller;

import com.phoenixware.inventorynexus.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }
}
