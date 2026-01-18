package com.phoenixware.inventorynexus.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "id_viewable")
    private int viewableId;

    @OneToMany
    private Set<OrderItem> orderItems;

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
