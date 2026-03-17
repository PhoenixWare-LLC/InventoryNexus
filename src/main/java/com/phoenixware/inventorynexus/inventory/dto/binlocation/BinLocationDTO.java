package com.phoenixware.inventorynexus.inventory.dto.binlocation;

import com.phoenixware.inventorynexus.shared.validation.Create;
import com.phoenixware.inventorynexus.shared.validation.Get;
import com.phoenixware.inventorynexus.shared.validation.Patch;
import com.phoenixware.inventorynexus.shared.validation.Update;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BinLocationDTO {
    @Null(groups = Create.class)
    @NotNull(
            groups = {
                    Get.class,
                    Update.class,
                    Patch.class
            },
            message = "Cannot be Null")
    UUID id;

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

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "height cannot be null!")
    @Positive(message = "height must be positive!")
    private BigDecimal height;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "width cannot be null!")
    @Positive(message = "width must be positive!")
    private BigDecimal width;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "depth cannot be null!")
    @Positive(message = "depth must be positive!")
    private BigDecimal depth;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "weightLimit cannot be null!")
    @Positive(message = "weightLimit must be positive")
    private BigDecimal weightLimit;

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

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            }, message = "palletShelving cannot be null!")
    private Boolean palletShelving;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "pushBackShelving cannot be null!")
    private Boolean pushBackShelving;

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

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "inUse cannot be null!"
    )
    private Boolean inUse;

}
