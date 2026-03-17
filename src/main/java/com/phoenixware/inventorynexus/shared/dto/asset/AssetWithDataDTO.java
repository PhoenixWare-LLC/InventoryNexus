package com.phoenixware.inventorynexus.shared.dto.asset;

import com.phoenixware.inventorynexus.shared.validation.Create;
import com.phoenixware.inventorynexus.shared.validation.Get;
import com.phoenixware.inventorynexus.shared.validation.Patch;
import com.phoenixware.inventorynexus.shared.validation.Update;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/16/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetWithDataDTO {
    @Null(groups = Create.class)
    @NotNull(
            groups = {
                    Get.class,
                    Update.class,
                    Patch.class
            },
            message = "id cannot be Null"
    )
    private UUID id;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "imageData cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "imageData cannot be blank!")
    private byte[] imageData;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "description cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "description cannot be blank!")
    @Size(min = 1, max = 255, message = "description must be between 1 and 255 characters!")
    private String description;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "alt cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "alt cannot be blank!")
    @Size(min = 1, max = 255, message = "alt must be between 1 and 255 characters!")
    private String alt;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "size cannot be Null"
    )
    @Max(value = 100_000)
    private Integer size;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "type cannot be null!")
    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "type cannot be blank!")
    @Size(min = 1, max = 15, message = "type must be between 1 and 15 characters!")
    private String type;
}
