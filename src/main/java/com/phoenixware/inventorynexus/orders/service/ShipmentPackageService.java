package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.shipmentpackage.ShipmentPackageDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface ShipmentPackageService {
    ShipmentPackageDTO create(ShipmentPackageDTO shipmentPackageDTO);
    ShipmentPackageDTO updateById(UUID id, ShipmentPackageDTO shipmentPackageDTO);
    ShipmentPackageDTO patchById(UUID id, ShipmentPackageDTO shipmentPackageDTO);
    ShipmentPackageDTO findById(UUID id);
    List<ShipmentPackageDTO> findAll();
    void deleteById(UUID id);
}
