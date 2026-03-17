package com.phoenixware.inventorynexus.inventory.entity;

import com.phoenixware.inventorynexus.shared.validation.Create;
import com.phoenixware.inventorynexus.shared.validation.Get;
import com.phoenixware.inventorynexus.shared.validation.Patch;
import com.phoenixware.inventorynexus.shared.validation.Update;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
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
@Table(name = "bin_location")
@AllArgsConstructor
@NoArgsConstructor
public class BinLocation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Null(groups = Create.class)
    @NotNull(
            groups = {
                    Get.class,
                    Update.class,
                    Patch.class
            },
            message = "id cannot be null!")
    private UUID id;

    @Column(name = "warehouse")
    private String warehouse;

    @Column(name = "floor")
    private String floor;

    @Column(name = "isle")
    private String isle;

    @Column(name = "row")
    private String row;

    @Column(name = "column")
    private String column;

    @Column(name = "location")
    private String location;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "depth")
    private BigDecimal depth;

    @Column(name = "weight_limit")
    private BigDecimal weightLimit;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Column(name = "pallet_shelving")
    private Boolean palletShelving;

    @Column(name = "push_back_shelving")
    private Boolean pushBackShelving;

    @Column(name = "sticker_location")
    private String stickerLocation;
}
