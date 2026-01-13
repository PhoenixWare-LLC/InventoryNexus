package com.phoenixware.inventorynexus.repository;

import com.phoenixware.inventorynexus.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
