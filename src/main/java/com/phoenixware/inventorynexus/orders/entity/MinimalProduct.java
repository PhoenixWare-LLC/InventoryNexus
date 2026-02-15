package com.phoenixware.inventorynexus.orders.entity;

import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("BASIC")
@Table(name = "product")
@NoArgsConstructor
public class MinimalProduct extends BaseProduct {
}
