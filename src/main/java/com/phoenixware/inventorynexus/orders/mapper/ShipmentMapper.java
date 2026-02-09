package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.ShipmentDTO;
import com.phoenixware.inventorynexus.orders.entity.Shipment;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Mapper
public interface ShipmentMapper {
    Shipment shipmentDtoToShipment (ShipmentDTO shipmentDTO);

    ShipmentDTO shipmentToShipmentDto(Shipment shipment);
}
