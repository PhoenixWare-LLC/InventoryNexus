package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.transaction.TransactionDTO;
import com.phoenixware.inventorynexus.inventory.entity.Transaction;
import com.phoenixware.inventorynexus.inventory.exception.transaction.TransactionNotFoundException;
import com.phoenixware.inventorynexus.inventory.mapper.TransactionMapper;
import com.phoenixware.inventorynexus.inventory.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDTO create(TransactionDTO transactionDTO) {
        return transactionMapper.transactionToTransactionDto(
                transactionRepository.save(
                        transactionMapper.transactionDTOToTransaction(
                                transactionDTO
                        )
                )
        );
    }

    @Override
    public TransactionDTO updateById(UUID id, TransactionDTO transactionDTO) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(TransactionNotFoundException::new);

        Transaction updatedTransaction = transactionMapper.transactionDTOToTransaction(transactionDTO);
        updatedTransaction.setId(id);

        transactionRepository.save(updatedTransaction);

        Transaction transactionFromDb = transactionRepository.findById(id)
                .orElseThrow(TransactionNotFoundException::new);

        return transactionMapper.transactionToTransactionDto(transactionFromDb);
    }

    @Override
    public TransactionDTO patchById(UUID id, TransactionDTO transactionDTO) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(TransactionNotFoundException::new);

        Transaction patchedTransaction = transactionMapper.patchTransactionFromTransactionDto(transactionDTO, existingTransaction);

        transactionRepository.save(patchedTransaction);

        Transaction transactionFromDb = transactionRepository.findById(id)
                .orElseThrow(TransactionNotFoundException::new);

        return transactionMapper.transactionToTransactionDto(transactionFromDb);
    }

    @Override
    public TransactionDTO findById(UUID id) {
        return transactionMapper.transactionToTransactionDto(
                transactionRepository.findById(id)
                        .orElseThrow(TransactionNotFoundException::new)
        );
    }

    @Override
    public List<TransactionDTO> findAll() {
        return transactionRepository
                .findAll()
                .stream()
                .map(transactionMapper::transactionToTransactionDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
        } else {
            throw new TransactionNotFoundException();
        }
    }
}
