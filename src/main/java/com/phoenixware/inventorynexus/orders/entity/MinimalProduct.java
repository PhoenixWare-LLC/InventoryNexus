package com.phoenixware.inventorynexus.orders.entity;

import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("BASIC")
@NoArgsConstructor
public class MinimalProduct extends BaseProduct {

    private long sold;
}
