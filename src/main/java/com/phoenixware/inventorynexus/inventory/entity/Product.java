package com.phoenixware.inventorynexus.inventory.entity;

import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@NoArgsConstructor
public class Product extends BaseProduct {
}
