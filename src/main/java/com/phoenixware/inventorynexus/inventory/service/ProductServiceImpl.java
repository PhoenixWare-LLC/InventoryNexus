package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.product.ProductDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import com.phoenixware.inventorynexus.inventory.exception.product.ProductNotFoundException;
import com.phoenixware.inventorynexus.inventory.mapper.ProductMapper;
import com.phoenixware.inventorynexus.orders.dto.minimalproduct.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import com.phoenixware.inventorynexus.orders.exception.minimalproduct.MinimalProductNotFoundException;
import com.phoenixware.inventorynexus.orders.mapper.MinimalProductMapper;
import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDTO;
import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import com.phoenixware.inventorynexus.shared.mapper.BaseProductMapper;
import com.phoenixware.inventorynexus.shared.repository.BaseProductRepository;
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
public class ProductServiceImpl implements ProductService {
    // TODO: Once Mapstruct 1.7 released, update remove if statements to make code polymorphic
    private final BaseProductRepository baseProductRepository;
    private final BaseProductMapper baseProductMapper;
    private final ProductMapper productMapper;
    private final MinimalProductMapper minimalProductMapper;

    @Override
    public BaseProductDTO create(BaseProductDTO baseProductDTO) {
        return baseProductMapper.mapToDto(
                baseProductRepository.save(
                        baseProductMapper.mapFromDto(baseProductDTO)
                )
        );
    }

    @Override
    public BaseProductDTO updateById(UUID id, BaseProductDTO baseProductDTO) {
        BaseProduct existingBaseProduct = baseProductRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        BaseProduct updatedBaseProduct = baseProductMapper.mapFromDto(baseProductDTO);
        updatedBaseProduct.setId(id);

        baseProductRepository.save(updatedBaseProduct);

        BaseProduct baseProductFromDb = baseProductRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        return baseProductMapper.mapToDto(baseProductFromDb);
    }

    @Override
    public BaseProductDTO patchById(UUID id, BaseProductDTO baseProductDTO) {
        if (baseProductDTO instanceof ProductDTO productDTO) {
            Product existingProduct = (Product) baseProductRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            Product patchedProduct = productMapper.patchFromDto(productDTO, existingProduct);

            baseProductRepository.save(patchedProduct);

            BaseProduct baseProductFromDb = baseProductRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            return baseProductMapper.mapToDto(baseProductFromDb);
        } else if (baseProductDTO instanceof MinimalProductDTO minimalProductDTO) {
            MinimalProduct existingMinimalProduct = (MinimalProduct) baseProductRepository.findById(id)
                    .orElseThrow(MinimalProductNotFoundException::new);

            MinimalProduct patchedMinimalProduct = minimalProductMapper.patchFromDto(minimalProductDTO, existingMinimalProduct);

            baseProductRepository.save(patchedMinimalProduct);

            BaseProduct baseProductFromDb = baseProductRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            return baseProductMapper.mapToDto(baseProductFromDb);
        } else {
            throw new IllegalArgumentException("Product given did not match MinimalProduct nor Product! Class: " + baseProductDTO.getClass());
        }
    }

    @Override
    public BaseProductDTO findById(UUID id) {
        return baseProductMapper.mapToDto(
                baseProductRepository.findById(id)
                        .orElseThrow(ProductNotFoundException::new)
        );
    }

    @Override
    public List<BaseProductDTO> findAll() {
        return baseProductRepository
                .findAll()
                .stream()
                .map(baseProductMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (baseProductRepository.existsById(id)) {
            baseProductRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException();
        }
    }
}
