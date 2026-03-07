package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/4/2026
 */
@Entity
@Table(name="contact")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

}
