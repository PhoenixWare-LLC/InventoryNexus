package com.phoenixware.inventorynexus.inventory.entity;

import jakarta.persistence.*;
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
    private UUID id;
}
