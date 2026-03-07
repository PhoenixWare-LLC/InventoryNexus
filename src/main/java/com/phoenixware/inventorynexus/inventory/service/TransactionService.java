package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.transaction.TransactionDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface TransactionService {
    TransactionDTO create(TransactionDTO transactionDTO);
    TransactionDTO updateById(UUID id, TransactionDTO transactionDTO);
    TransactionDTO patchById(UUID id, TransactionDTO transactionDTO);
    TransactionDTO findById(UUID id);
    List<TransactionDTO> findAll();
    void deleteById(UUID id);
}
