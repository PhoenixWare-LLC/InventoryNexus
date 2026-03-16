package com.phoenixware.inventorynexus.inventory.entity;

import com.phoenixware.inventorynexus.shared.validation.Create;
import com.phoenixware.inventorynexus.shared.validation.Get;
import com.phoenixware.inventorynexus.shared.validation.Patch;
import com.phoenixware.inventorynexus.shared.validation.Update;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

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
            message = "Cannot be Null")
    private UUID id;
}
