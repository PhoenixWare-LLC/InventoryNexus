package com.phoenixware.inventorynexus.orders.entity;

import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
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


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "fk_product_id")
    private BaseProduct product;

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

    @Column(name = "modification_timestamp")
    private LocalDateTime modificationTimestamp;

    // TODO: for now this will be only a String object, however in the future, this will need to store the key of the user that performed this action.
    @Column(name = "created_by")
    private String createdBy;

    // TODO: for now this will be only a String object, however in the future, this will need to store the key of the user that performed this action.
    @Column(name = "modified_by")
    private String modifiedBy;
}
