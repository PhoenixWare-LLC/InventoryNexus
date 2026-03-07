package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.shipment.ShipmentDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface ShipmentService {
    ShipmentDTO create(ShipmentDTO shipmentDTO);
    ShipmentDTO updateById(UUID id, ShipmentDTO shipmentDTO);
    ShipmentDTO patchById(UUID id, ShipmentDTO shipmentDTO);
    ShipmentDTO findById(UUID id);
    List<ShipmentDTO> findAll();
    void deleteById(UUID id);
}
