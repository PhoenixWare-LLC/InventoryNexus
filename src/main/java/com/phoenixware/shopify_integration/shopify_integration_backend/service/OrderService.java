package com.phoenixware.shopify_integration.shopify_integration_backend.service;

import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getOrder(int id);
    Order commit(Order order);
    void deleteById(int id);
}
