package com.phoenixware.shopify_integration.shopify_integration_backend.dao;

import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDAO {
    Order commit(Order order);
    Order getById(Integer id);
    List<Order> getAllUnshippedFromTimestamp(LocalDateTime start);
    List<Order> getAllUnshippedByMarketplace(List<String> marketplaces);
    List<Order> getAll();
    int markShippedOrdersFulfilled();
    void ship(Order order, String trackingNumber);
    void delete(Order order);
    void deleteById(int id);
    int deleteCanceled();
}
