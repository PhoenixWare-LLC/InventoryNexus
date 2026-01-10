package com.phoenixware.shopify_integration.shopify_integration_backend.service;

import com.phoenixware.shopify_integration.shopify_integration_backend.dao.OrderDAO;
import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;
import com.phoenixware.shopify_integration.shopify_integration_backend.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    public OrderServiceImpl (OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public Order getOrder(int id) {
        return orderDAO.getById(id);
    }

    @Override
    @Transactional
    public Order commit(Order order) {
        return orderDAO.commit(order);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        orderDAO.deleteById(id);
    }
}
