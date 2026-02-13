package com.phoenixware.inventorynexus.orders.dto;

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
public class OrderDTO {
    private UUID id;
    private int viewableId;
    private String name;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String postalCode;
    private BigDecimal total;
    private LocalDateTime creationTimestamp;
    private boolean shipped;
    private boolean fulfilled;
    private String trackingNumber;
    private String marketplace;
    private String status;
}
