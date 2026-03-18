package com.phoenixware.inventorynexus.inventory.dto.parentproduct;

import com.phoenixware.inventorynexus.shared.entity.Asset;
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
 * Created:     1/19/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParentProductDTO {
    @Null(groups = Create.class)
    private UUID id;

    @Null(groups = {
            Create.class,
            Update.class,
            Patch.class
    })
    private Asset asset;

    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "title cannot be blank!"
    )
    @Size(min = 1, max = 50, message = "title must be between 1 and 50 characters!")
    private String title;

    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "title cannot be blank!"
    )
    @Size(min = 1, max = 255, message = "title must be between 1 and 255 characters!")
    private String description;

    @NotBlank(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "title cannot be blank!"
    )
    @Size(min = 1, max = 500, message = "title must be between 1 and 500 characters!")
    private String notes;

    @NotNull(
            groups = {
                    Get.class,
                    Create.class,
                    Update.class
            },
            message = "title cannot be null!"
    )
    @Min(value = 1)
    @Max(value = 100)
    private Integer targetMargin;
}
