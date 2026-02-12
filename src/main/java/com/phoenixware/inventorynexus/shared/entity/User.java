package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "app_user")
@Data
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToMany
    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "fk_app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_role_id")
    )
    private List<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "app_user_privilege",
            joinColumns = @JoinColumn(name = "fk_app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_privilege_id")
    )
    private List<Privilege> privileges;

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
