package com.phoenixware.inventorynexus.inventory.entity;

import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

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
@Table(name = "product")
@NoArgsConstructor
public class Product extends BaseProduct {
}
