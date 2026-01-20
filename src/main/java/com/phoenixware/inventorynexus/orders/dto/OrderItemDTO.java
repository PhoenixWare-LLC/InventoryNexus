package com.phoenixware.inventorynexus.orders.dto;

import com.phoenixware.inventorynexus.orders.entity.Order;
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
public class OrderItemDTO {
    private UUID id;
    private UUID orderId;
    private int viewableId;
    private int viewableOrderId;
    private String sku;
    private String title;
    private BigDecimal price;
    private int quantity;
    private LocalDateTime creationTimestamp;
    private LocalDateTime modificationTimestamp;
    private String createdBy;
    private String modifiedBy;
}
