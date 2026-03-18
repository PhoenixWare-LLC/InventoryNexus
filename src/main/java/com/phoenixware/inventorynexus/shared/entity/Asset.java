package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/16/2026
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "asset")
@AllArgsConstructor
@NoArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Lob
    @JdbcTypeCode(Types.BINARY)
    @Column(name = "asset_data")
    private byte[] imageData;

    @Column(name = "description")
    private String description;

    @Column(name = "alt")
    private String alt;

    @Column(name = "size")
    private Long size;

    @Column(name = "type")
    private String type;
}
