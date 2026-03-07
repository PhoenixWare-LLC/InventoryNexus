package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.shipmentpackage.ShipmentPackageDTO;
import com.phoenixware.inventorynexus.orders.entity.ShipmentPackage;
import com.phoenixware.inventorynexus.orders.exception.shipmentpackage.ShipmentPackageNotFoundException;
import com.phoenixware.inventorynexus.orders.mapper.ShipmentPackageMapper;
import com.phoenixware.inventorynexus.orders.repository.ShipmentPackageRepository;
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
public class ShipmentPackageServiceImpl implements ShipmentPackageService{
    private final ShipmentPackageRepository shipmentPackageRepository;
    private final ShipmentPackageMapper shipmentPackageMapper;

    @Override
    public ShipmentPackageDTO create(ShipmentPackageDTO shipmentPackageDTO) {
        return shipmentPackageMapper.shipmentPackageToShipmentPackageDto(
                shipmentPackageRepository.save(
                        shipmentPackageMapper.shipmentPackageDtoToShipmentPackage(
                                shipmentPackageDTO
                        )
                )
        );
    }

    @Override
    public ShipmentPackageDTO updateById(UUID id, ShipmentPackageDTO shipmentPackageDTO) {
        ShipmentPackage existingShipmentPackage = shipmentPackageRepository.findById(id)
                .orElseThrow(ShipmentPackageNotFoundException::new);

        ShipmentPackage updatedShipmentPackage = shipmentPackageMapper.shipmentPackageDtoToShipmentPackage(shipmentPackageDTO);
        updatedShipmentPackage.setId(id);

        shipmentPackageRepository.save(updatedShipmentPackage);

        ShipmentPackage shipmentPackageFromDb = shipmentPackageRepository.findById(id)
                .orElseThrow(ShipmentPackageNotFoundException::new);

        return shipmentPackageMapper.shipmentPackageToShipmentPackageDto(shipmentPackageFromDb);
    }

    @Override
    public ShipmentPackageDTO patchById(UUID id, ShipmentPackageDTO shipmentPackageDTO) {
        ShipmentPackage existingShipmentPackage = shipmentPackageRepository.findById(id)
                .orElseThrow(ShipmentPackageNotFoundException::new);

        ShipmentPackage patchedShipmentPackage = shipmentPackageMapper.patchShipmentPackageFromShipmentPackageDto(shipmentPackageDTO, existingShipmentPackage);

        shipmentPackageRepository.save(patchedShipmentPackage);

        ShipmentPackage shipmentPackageFromDb = shipmentPackageRepository.findById(id)
                .orElseThrow(ShipmentPackageNotFoundException::new);

        return shipmentPackageMapper.shipmentPackageToShipmentPackageDto(shipmentPackageFromDb);
    }

    @Override
    public ShipmentPackageDTO findById(UUID id) {
        return shipmentPackageMapper.shipmentPackageToShipmentPackageDto(
                shipmentPackageRepository.findById(id)
                        .orElseThrow(ShipmentPackageNotFoundException::new)
        );
    }

    @Override
    public List<ShipmentPackageDTO> findAll() {
        return shipmentPackageRepository
                .findAll()
                .stream()
                .map(shipmentPackageMapper::shipmentPackageToShipmentPackageDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (shipmentPackageRepository.existsById(id)) {
            shipmentPackageRepository.deleteById(id);
        } else {
            throw new ShipmentPackageNotFoundException();
        }

    }
}
