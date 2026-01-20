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
public class ShipmentPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "fk_shipment")
    private UUID fkShipment;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "status")
    private String status;

    // TODO: for now this will only be a string. However in the future this should be translated to an PackageType Object. Since box sizes and package sizes will be constant.
    @Column(name = "package_type")
    private String packageType;

    //indicate each size here in inches, so that it can be seen throughout other parts of the program what metric the system is using.
    @Column(name = "length_in_inches")
    private BigDecimal lengthInInches;

    @Column(name = "width_in_inches")
    private BigDecimal widthInInches;

    @Column(name = "height_in_inches")
    private BigDecimal heightInInches;

    @Column(name = "weight_in_pounds")
    private BigDecimal weightInPounds;

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
