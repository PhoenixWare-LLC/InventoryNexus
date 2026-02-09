package com.phoenixware.inventorynexus.orders.repository;

import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface MinimalProductRepository extends JpaRepository<MinimalProduct, UUID> {
}
