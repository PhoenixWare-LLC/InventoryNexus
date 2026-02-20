package com.phoenixware.inventorynexus.orders.dto.orderitem;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.phoenixware.inventorynexus.orders.dto.order.OrderDTO;
import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDTO;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "id")
public class OrderItemDetailedDTO {
    private UUID id;
    private OrderDTO orderDTO;
    private BaseProductDTO baseProductDTO;
    private int viewableId;
    private int viewableOrderId;
    private String sku;
    private String title;
    private BigDecimal price;
    private int quantity;
    private LocalDateTime creationTimestamp;
}
