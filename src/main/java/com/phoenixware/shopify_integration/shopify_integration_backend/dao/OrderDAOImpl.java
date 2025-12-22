package com.phoenixware.shopify_integration.shopify_integration_backend.dao;

import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderDAOImpl implements OrderDAO{
    private EntityManager entityManager;

    @Autowired
    public OrderDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void saveOrder(Order theOrder) {
        entityManager.persist(theOrder);
    }
    @Override
    public Order getOrderById (Integer id) {
        return entityManager.find(Order.class, id);
    }
}
