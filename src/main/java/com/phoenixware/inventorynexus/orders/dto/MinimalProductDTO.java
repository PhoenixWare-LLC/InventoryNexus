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
public class MinimalProductDTO {
    // Base Fields
    private UUID id;
    private String sku;
    private BigDecimal price;
    private BigDecimal cost;
    private int upc;
    private int gs1;
    private LocalDateTime creationTimestamp;
    private LocalDateTime modificationTimestamp;
    private String createdBy;
    private String modifiedBy;
}
