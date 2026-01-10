package com.phoenixware.shopify_integration.shopify_integration_backend.repository;

import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
