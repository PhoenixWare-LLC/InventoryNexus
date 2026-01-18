package com.phoenixware.inventorynexus.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Data
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "fk_orderid")
    private UUID orderId;

    @Column(name = "id_viewable")
    private int viewableId;

    @Column(name = "order_id_viewable")
    private int viewableOrderId;

    @ManyToOne
    private Order order;

    @Column(name = "sku")
    private String sku;

    @Column(name = "item_name")
    private String title;

    @Column(name = "base_price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "creation_timestamp", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP = DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationTimestamp;
}
