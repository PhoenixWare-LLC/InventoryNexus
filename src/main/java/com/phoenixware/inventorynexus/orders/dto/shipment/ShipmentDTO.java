package com.phoenixware.inventorynexus.orders.dto.shipment;

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
public class ShipmentDTO {
    private UUID id;
    private String masterTrackingNumber;
    private String carrier;
    private String service;
    private BigDecimal cost;
    private int numberOfPackages;
    private String type;
    private String status;
    private LocalDateTime creationTimestamp;
    private LocalDateTime modificationTimestamp;
    private String createdBy;
    private String modifiedBy;
}
