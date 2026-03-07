package com.phoenixware.inventorynexus.orders.entity;

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
@Table(name = "shipment")
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "master_tracking_number")
    private String masterTrackingNumber;

    @Column(name = "carrier")
    private String carrier;

    // TODO: for now this will be a name, however in the future, this should spin off to it's own Service object.
    @Column(name = "service")
    private String service;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "number_of_packages")
    private int numberOfPackages;

    // type will either be quote, or invoice.
    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP = DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP = DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    // TODO: for now this will be only a String object, however in the future, this will need to store the key of the user that performed this action.
    @Column(name = "created_by", nullable = false, insertable = false, updatable = false)
    private String createdBy;

    // TODO: for now this will be only a String object, however in the future, this will need to store the key of the user that performed this action.
    @Column(name = "modified_by", nullable = false, insertable = false, updatable = false)
    private String modifiedBy;
}
