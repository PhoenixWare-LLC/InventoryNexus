package com.phoenixware.inventorynexus.orders.dto.order;

import com.phoenixware.inventorynexus.orders.dto.orderitem.OrderItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailedDTO {
    private UUID id;
    private List<OrderItemDTO> orderItems;
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
