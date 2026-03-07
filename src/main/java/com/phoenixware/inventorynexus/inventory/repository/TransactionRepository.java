package com.phoenixware.inventorynexus.inventory.repository;

import com.phoenixware.inventorynexus.inventory.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    UUID id(UUID id);
}
