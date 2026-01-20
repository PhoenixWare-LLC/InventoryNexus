package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.ShipmentPackageDTO;
import com.phoenixware.inventorynexus.orders.entity.ShipmentPackage;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Mapper
public interface ShipmentPackageMapper {
    ShipmentPackage shipmentPackageDtoToShipmentPackage(ShipmentPackageDTO shipmentPackageDTO);

    ShipmentPackageDTO shipmentPackageToShipmentPackageDto(ShipmentPackage shipmentPackage);
}
