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
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "warehouse cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "warehouse cannot be blank!")
    @Size(min = 1, max = 5, message = "warehouse prefix length invalid!")
    private String warehouse;

    @Column(name = "floor")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "floor cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "floor cannot be blank!")
    @Size(min = 1, max = 5, message = "floor prefix length invalid!")
    private String floor;

    @Column(name = "isle")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "isle cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "isle cannot be blank!")
    @Size(min = 1, max = 5, message = "isle prefix length invalid!")
    private String isle;

    @Column(name = "row")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "row cannot be null!")
    @NotBlank(message = "row cannot be blank!")
    @Size(min = 1, max = 5, message = "row prefix length invalid!")
    private String row;

    @Column(name = "column")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "column cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "column cannot be blank!")
    @Size(min = 1, max = 5, message = "column prefix length invalid!")
    private String column;

    @Column(name = "location")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "location cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "location cannot be blank!")
    @Size(min = 5, max = 25, message = "location length invalid!")
    private String location;

    @Column(name = "height")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "height cannot be null!")
    @Positive(message = "height must be positive!")
    private BigDecimal height;

    @Column(name = "width")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "width cannot be null!")
    @Positive(message = "width must be positive!")
    private BigDecimal width;

    @Column(name = "depth")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "depth cannot be null!")
    @Positive(message = "depth must be positive!")
    private BigDecimal depth;

    @Column(name = "weight_limit")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "weightLimit cannot be null!")
    @Positive(message = "weightLimit must be positive")
    private BigDecimal weightLimit;

    @Column(name = "unit_of_measure")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "unitOfMeasure cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "unitOfMeasure cannot be blank!")
    @Pattern(
            regexp = "imperial|metric",
            message = "unitOfMeasure must be either 'imperial' or 'metric'"
    )
    @Size(min = 6, max = 8, message = "unitOfMeasure must be between 6 and 8 characters in length")
    private String unitOfMeasure;

    @Column(name = "pallet_shelving")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            }, message = "palletShelving cannot be null!")
    private Boolean palletShelving;

    @Column(name = "push_back_shelving")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "pushBackShelving cannot be null!")
    private Boolean pushBackShelving;

    @Column(name = "sticker_location")
    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "stickerLocation cannot be null!"
    )
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "stickerLocation cannot be blank!"
    )
    @Pattern(
            regexp = "above|below",
            message = "stickerLocation must be either 'above' or 'below'"
    )
    private String stickerLocation;
}
