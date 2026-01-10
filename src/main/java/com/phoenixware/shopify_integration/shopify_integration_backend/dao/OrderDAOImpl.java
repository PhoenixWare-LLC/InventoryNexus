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

    private final EntityManager entityManager;

    public OrderDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Order commit(Order theOrder) {
        Order dbOrder = entityManager.merge(theOrder);

        return dbOrder;
        // Below is only if you want to create an order... but what if I want to just have an update/create method.
//        entityManager.persist(theOrder);
    }
    @Override
    public Order getById(Integer id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> getAllUnshippedFromTimestamp(LocalDateTime start) {
        Objects.requireNonNull(start, "Start cannot be null!");
        TypedQuery<Order> theQuery = entityManager.createQuery("SELECT order FROM Order order WHERE order.creationTimestamp>=:start", Order.class);
        theQuery.setParameter("start", start);
        return theQuery.getResultList();
    }

    @Override
    public List<Order> getAllUnshippedByMarketplace(List<String> marketplaces) {
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
    public List<Order> getAll() {
        TypedQuery<Order> theQuery = entityManager.createQuery("SELECT order FROM Order order", Order.class);
        return theQuery.getResultList();
    }

    @Override
    public int markShippedOrdersFulfilled() {
        return entityManager.createQuery("UPDATE Order SET fulfilled=true WHERE shipped=true").executeUpdate();
    }

    @Override
    public void ship(Order order, String trackingNumber) {
        order.setTrackingNumber(trackingNumber);
        order.setShipped(true);
        entityManager.merge(order);
        markShippedOrdersFulfilled();
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }

    @Override
    public void deleteById(int id) {
        // find the order
        Order order = entityManager.find(Order.class, id);

        // delete this order
        entityManager.remove(order);
    }

    @Override
    public int deleteCanceled() {
        return entityManager.createQuery("DELETE FROM Order WHERE status='CANCELED'").executeUpdate();
    }

}
