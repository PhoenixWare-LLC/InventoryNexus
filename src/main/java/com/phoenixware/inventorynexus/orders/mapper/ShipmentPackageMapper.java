package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.shipmentpackage.ShipmentPackageDTO;
import com.phoenixware.inventorynexus.orders.entity.ShipmentPackage;
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
public interface ShipmentPackageMapper {
    ShipmentPackage shipmentPackageDtoToShipmentPackage(ShipmentPackageDTO shipmentPackageDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ShipmentPackage patchShipmentPackageFromShipmentPackageDto(ShipmentPackageDTO shipmentPackageDTO, @MappingTarget ShipmentPackage shipmentPackage);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ShipmentPackageDTO patchShipmentPackageDtoFromShipmentPackage(ShipmentPackage shipmentPackage, @MappingTarget ShipmentPackageDTO shipmentPackageDTO);

    ShipmentPackageDTO shipmentPackageToShipmentPackageDto(ShipmentPackage shipmentPackage);
}
