package com.phoenixware.inventorynexus.inventory.entity;

import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Getter
@Setter
@Builder
@Entity
@DiscriminatorValue("FULL")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseProduct {
    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "taxable")
    private boolean taxable;
}
