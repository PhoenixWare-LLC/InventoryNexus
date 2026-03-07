package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.productlocation.ProductLocationDTO;
import com.phoenixware.inventorynexus.inventory.entity.ProductLocation;
import com.phoenixware.inventorynexus.inventory.exception.productlocation.ProductLocationNotFoundException;
import com.phoenixware.inventorynexus.inventory.mapper.ProductLocationMapper;
import com.phoenixware.inventorynexus.inventory.repository.ProductLocationRepository;
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
public class ProductLocationServiceImpl implements ProductLocationService {
    private final ProductLocationRepository productLocationRepository;
    private final ProductLocationMapper productLocationMapper;

    @Override
    public ProductLocationDTO create(ProductLocationDTO productLocationDTO) {
        return productLocationMapper.productLocationToProductLocationDto(
                productLocationRepository.save(
                        productLocationMapper.productLocationDtoToProductLocation(
                                productLocationDTO
                        )
                )
        );
    }

    @Override
    public ProductLocationDTO updateById(UUID id, ProductLocationDTO productLocationDTO) {
        ProductLocation existingProductLocation = productLocationRepository.findById(id)
                .orElseThrow(ProductLocationNotFoundException::new);

        ProductLocation updatedProductLocation = productLocationMapper.productLocationDtoToProductLocation(productLocationDTO);
        updatedProductLocation.setId(id);

        productLocationRepository.save(updatedProductLocation);

        ProductLocation productLocationFromDb = productLocationRepository.findById(id)
                .orElseThrow(ProductLocationNotFoundException::new);

        return productLocationMapper.productLocationToProductLocationDto(productLocationFromDb);
    }

    @Override
    public ProductLocationDTO patchById(UUID id, ProductLocationDTO productLocationDTO) {
        ProductLocation existingProductLocation = productLocationRepository.findById(id)
                .orElseThrow(ProductLocationNotFoundException::new);

        ProductLocation patchedProductLocation = productLocationMapper.patchProductLocationFromProductLocationDto(productLocationDTO, existingProductLocation);

        productLocationRepository.save(patchedProductLocation);

        ProductLocation productLocationFromDb = productLocationRepository.findById(id)
                .orElseThrow(ProductLocationNotFoundException::new);

        return productLocationMapper.productLocationToProductLocationDto(productLocationFromDb);
    }

    @Override
    public ProductLocationDTO findById(UUID id) {
        return productLocationMapper.productLocationToProductLocationDto(
                productLocationRepository.findById(id)
                        .orElseThrow(ProductLocationNotFoundException::new)
        );
    }

    @Override
    public List<ProductLocationDTO> findAll() {
        return productLocationRepository
                .findAll()
                .stream()
                .map(productLocationMapper::productLocationToProductLocationDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (productLocationRepository.existsById(id)) {
            productLocationRepository.deleteById(id);
        } else {
            throw new ProductLocationNotFoundException();
        }
    }
}
