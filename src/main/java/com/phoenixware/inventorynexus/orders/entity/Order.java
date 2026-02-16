package com.phoenixware.inventorynexus.orders.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<OrderItem> orderItems;

    @Column(name = "name")
    private String name;

    @Column(name = "street_1")
    private String street1;

    @Column(name = "street_2")
    private String street2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "creation_timestamp", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP = DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationTimestamp;

    @Column(name = "shipped")
    private boolean shipped;

    @Column(name = "fulfilled")
    private boolean fulfilled;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name= "marketplace")
    private String marketplace;

    @Column(name = "status")
    private String status;
}
