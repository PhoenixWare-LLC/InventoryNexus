package com.phoenixware.inventorynexus.orders.dto.shipment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDTO {
    private UUID id;
    private String masterTrackingNumber;
    private String carrier;
    private String service;
    private BigDecimal cost;
    private int numberOfPackages;
    private String type;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String createdBy;
    private String modifiedBy;
}
