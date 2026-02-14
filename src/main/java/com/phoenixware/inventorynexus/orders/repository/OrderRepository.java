package com.phoenixware.inventorynexus.orders.repository;

import com.phoenixware.inventorynexus.orders.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @EntityGraph(attributePaths = {"orderItems"})
    List<Order> findAll();
    @EntityGraph(attributePaths = {"orderItems"})
    Optional<Order> findById(UUID id);

    @EntityGraph(attributePaths = {"orderItems"})
    List<Order> findByShipped(boolean shipped);

    List<Order> findOrdersByCreationTimestamp(LocalDateTime creationTimestamp);

}
