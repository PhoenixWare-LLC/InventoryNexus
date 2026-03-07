package com.phoenixware.inventorynexus.shared.repository;

import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface BaseProductRepository extends JpaRepository<BaseProduct, UUID> {
}
