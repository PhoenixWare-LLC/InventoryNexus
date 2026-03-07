package com.phoenixware.inventorynexus.inventory.repository;

import com.phoenixware.inventorynexus.inventory.entity.ParentProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface ParentProductRepository extends JpaRepository <ParentProduct, UUID> {
    UUID id(UUID id);
}
