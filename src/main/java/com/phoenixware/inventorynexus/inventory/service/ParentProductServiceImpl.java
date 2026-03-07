package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.parentproduct.ParentProductDTO;
import com.phoenixware.inventorynexus.inventory.entity.ParentProduct;
import com.phoenixware.inventorynexus.inventory.exception.parentproduct.ParentProductNotFoundException;
import com.phoenixware.inventorynexus.inventory.mapper.ParentProductMapper;
import com.phoenixware.inventorynexus.inventory.repository.ParentProductRepository;
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
public class ParentProductServiceImpl implements ParentProductService{
    private final ParentProductRepository parentProductRepository;
    private final ParentProductMapper parentProductMapper;

    @Override
    public ParentProductDTO create(ParentProductDTO productDTO) {
        return parentProductMapper.parentProductToParentProductDto(
                parentProductRepository.save(
                        parentProductMapper.parentProductDtoToParentProduct(
                                productDTO
                        )
                )
        );
    }

    @Override
    public ParentProductDTO updateById(UUID id, ParentProductDTO productDTO) {
        ParentProduct existingParentProduct = parentProductRepository.findById(id)
                .orElseThrow(ParentProductNotFoundException::new);

        ParentProduct updatedParentProduct = parentProductMapper.parentProductDtoToParentProduct(
                productDTO
        );
        updatedParentProduct.setId(id);

        parentProductRepository.save(updatedParentProduct);

        ParentProduct parentProductFromDb = parentProductRepository.findById(id)
                .orElseThrow(ParentProductNotFoundException::new);

        return parentProductMapper.parentProductToParentProductDto(parentProductFromDb);
    }

    @Override
    public ParentProductDTO patchById(UUID id, ParentProductDTO productDTO) {
        ParentProduct existingParentProduct = parentProductRepository.findById(id)
                .orElseThrow(ParentProductNotFoundException::new);

        ParentProduct patchedParentProduct = parentProductMapper.patchParentProductFromParentProductDto(productDTO, existingParentProduct);

        parentProductRepository.save(patchedParentProduct);

        ParentProduct parentProductFromDb = parentProductRepository.findById(id)
                .orElseThrow(ParentProductNotFoundException::new);
        return parentProductMapper.parentProductToParentProductDto(parentProductFromDb);
    }

    @Override
    public ParentProductDTO findById(UUID id) {
        return null;
    }

    @Override
    public List<ParentProductDTO> findAll() {
        return parentProductRepository
                .findAll()
                .stream()
                .map(parentProductMapper::parentProductToParentProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (parentProductRepository.existsById(id)) {
            parentProductRepository.deleteById(id);
        } else {
            throw new ParentProductNotFoundException();
        }
    }
}
