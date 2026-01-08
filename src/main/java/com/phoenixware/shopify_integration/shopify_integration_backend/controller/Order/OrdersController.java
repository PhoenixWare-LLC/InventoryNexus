package com.phoenixware.shopify_integration.shopify_integration_backend.controller.Order;

import com.phoenixware.shopify_integration.shopify_integration_backend.dao.OrderDAO;
import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;
import com.phoenixware.shopify_integration.shopify_integration_backend.exception.OrderNotFoundException;
import com.phoenixware.shopify_integration.shopify_integration_backend.exception.OrderExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersController {

    private final OrderDAO orderDAO;

    public OrdersController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderDAO.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        Order order = orderDAO.getOrderById(orderId);
        if (order == null) {
            throw new OrderNotFoundException("Order id not found - " + orderId);
        }
        return orderDAO.getOrderById(orderId);
    }

    @ExceptionHandler
    public ResponseEntity<OrderExceptionResponse> handleException(OrderNotFoundException exc) {
        // create an OrderNotFoundException

        OrderExceptionResponse error = new OrderExceptionResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(LocalDateTime.now());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderExceptionResponse> handleException(Exception exc) {
        OrderExceptionResponse error = new OrderExceptionResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(LocalDateTime.now());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
