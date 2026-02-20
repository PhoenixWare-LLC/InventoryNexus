package com.phoenixware.inventorynexus.orders.dto.shipmentpackage;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Data
@Builder
public class ShipmentPackageDTO {
    private UUID id;
    private UUID fkShipment;
    private String trackingNumber;
    private String status;
    private String packageType;
    private BigDecimal lengthInInches;
    private BigDecimal widthInInches;
    private BigDecimal heightInInches;
    private BigDecimal weightInPounds;
    private LocalDateTime creationTimestamp;
    private LocalDateTime modificationTimestamp;
    private String createdBy;
    private String modifiedBy;
}
