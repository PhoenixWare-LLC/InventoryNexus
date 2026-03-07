package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.shipment.ShipmentDTO;
import com.phoenixware.inventorynexus.orders.entity.Shipment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Mapper
public interface ShipmentMapper {
    Shipment shipmentDtoToShipment (ShipmentDTO shipmentDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Shipment patchShipmentFromShipmentDto(ShipmentDTO shipmentDTO, @MappingTarget Shipment shipment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ShipmentDTO patchShipmentDtoFromShipment(Shipment shipment, @MappingTarget ShipmentDTO shipmentDTO);

    ShipmentDTO shipmentToShipmentDto(Shipment shipment);
}
