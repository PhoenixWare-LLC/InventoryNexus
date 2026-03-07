package com.phoenixware.inventorynexus.inventory.repository;

import com.phoenixware.inventorynexus.inventory.entity.ProductLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface ProductLocationRepository extends JpaRepository<ProductLocation, UUID> {
}
