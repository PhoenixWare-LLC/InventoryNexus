package com.phoenixware.inventorynexus.shared.dto.baseproduct;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/14/2026
 */
@Data
public abstract class BaseProductDTO {
    private UUID id;
    private String sku;
    private BigDecimal price;
    private BigDecimal cost;
    private String upc;
    private String gs1;
    private LocalDateTime creationTimestamp;
    private LocalDateTime modificationTimestamp;
    private String createdBy;
    private String modifiedBy;
}
