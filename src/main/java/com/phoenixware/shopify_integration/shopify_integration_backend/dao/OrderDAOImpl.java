package com.phoenixware.shopify_integration.shopify_integration_backend.dao;

import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public List<Order> getAllUnshippedOrdersFromTimestamp(LocalDateTime start) {
        Objects.requireNonNull(start, "Start cannot be null!");
        TypedQuery<Order> theQuery = entityManager.createQuery("SELECT order FROM Order order WHERE order.creationTimestamp>=:start", Order.class);
        theQuery.setParameter("start", start);
        return theQuery.getResultList();
    }

    @Override
    public Order getOrderById(String id) {
        Objects.requireNonNull(id, "ID cannot be null!");

        TypedQuery<Order> theQuery = entityManager.createQuery("SELECT order FROM Order order WHERE order.id=:theId", Order.class);
        theQuery.setParameter("theId", id);
        return theQuery.getSingleResult();
    }

    @Override
    public List<Order> getAllUnshippedOrdersByMarketplace(List<String> marketplaces) {
        Objects.requireNonNull(marketplaces, "Marketplaces cannot be null!");

        if (marketplaces.isEmpty()) {
            return null;
        } else {
            TypedQuery<Order> theQuery = entityManager.createQuery("SELECT order FROM Order order WHERE order.marketplace IN (:marketplace)", Order.class);
            theQuery.setParameter("marketplace", marketplaces);
            return theQuery.getResultList();
        }
    }

    @Override
    public List<Order> getAllOrders() {
        TypedQuery<Order> theQuery = entityManager.createQuery("SELECT order FROM Order order", Order.class);
        return theQuery.getResultList();
    }

    @Override
    public int markShippedOrdersFulfilled() {
        return entityManager.createQuery("UPDATE Order SET fulfilled=true WHERE shipped=true").executeUpdate();
    }

    @Override
    @Transactional
    public void shipOrder(Order order, String trackingNumber) {
        order.setTrackingNumber(trackingNumber);
        order.setShipped(true);
        entityManager.merge(order);
        markShippedOrdersFulfilled();
    }

    @Override
    @Transactional
    public void deleteOrder(Order order) {
        entityManager.remove(order);
    }

    @Override
    @Transactional
    public void deleteOrderById(int id) {
        // find the order
        Order order = entityManager.find(Order.class, id);

        // delete this order
        entityManager.remove(order);
    }

    @Override
    @Transactional
    public int deleteCanceledOrders() {
        return entityManager.createQuery("DELETE FROM Order WHERE status='CANCELED'").executeUpdate();
    }

}
