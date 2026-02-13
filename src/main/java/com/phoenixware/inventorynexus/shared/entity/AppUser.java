package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Entity
@Table(name = "app_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany
    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "fk_app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_role_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> userRoles;

    @ManyToMany
    @JoinTable(
            name = "app_user_privilege",
            joinColumns = @JoinColumn(name = "fk_app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_privilege_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Privilege> userPrivileges;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 50)
    private String username;  // often defaults to email

    @Column(nullable = false, length = 128)
    private String password;  // hashed

    @Column(nullable = false)
    private boolean active = false;

    @Column(nullable = false)
    private boolean admin = false;

    @Column(name = "mfa_type", nullable = false, length = 50)
    private String mfaType = "email";

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", insertable = false, updatable = false, length = 50)
    private String createdBy;
}
