package com.phoenixware.inventorynexus.inventory.mapper;

import com.phoenixware.inventorynexus.inventory.dto.transaction.TransactionDTO;
import com.phoenixware.inventorynexus.inventory.entity.Transaction;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
@Mapper
public interface TransactionMapper {
    Transaction transactionDTOToTransaction(TransactionDTO transactionDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Transaction patchTransactionFromTransactionDto(TransactionDTO transactionDTO, @MappingTarget Transaction transaction);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TransactionDTO patchTransactionDtoFromTransaction(Transaction transaction, @MappingTarget TransactionDTO transactionDTO);

    TransactionDTO transactionToTransactionDto(Transaction transaction);
}
