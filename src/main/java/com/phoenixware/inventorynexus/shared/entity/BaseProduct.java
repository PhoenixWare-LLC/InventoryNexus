package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
@Table(name = "products", schema = "inventory")
public abstract class BaseProduct {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "upc")
    private int upc;

    @Column(name = "gs1")
    private int gs1;

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
