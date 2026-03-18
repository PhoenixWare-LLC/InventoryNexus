package com.phoenixware.inventorynexus.inventory.entity;

import com.phoenixware.inventorynexus.shared.entity.Asset;
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
@Table(name = "parent_product")
@AllArgsConstructor
@NoArgsConstructor
public class ParentProduct {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "notes")
    private String notes;

    @Column(name = "target_margin")
    private Integer targetMargin;
}
