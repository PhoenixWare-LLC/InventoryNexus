package com.phoenixware.shopify_integration.shopify_integration_backend.dao;

import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;

public interface OrderDAO {
    void saveOrder(Order order);
    Order getOrderById(Integer id);
}
