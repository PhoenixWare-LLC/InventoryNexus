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
