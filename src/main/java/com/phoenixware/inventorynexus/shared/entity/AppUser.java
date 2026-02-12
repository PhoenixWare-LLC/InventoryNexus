package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "app_user")
@Data
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
    private Set<Role> userRoles;

    @ManyToMany
    @JoinTable(
            name = "app_user_privilege",
            joinColumns = @JoinColumn(name = "fk_app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_privilege_id")
    )
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;
        return isActive() == appUser.isActive() && isAdmin() == appUser.isAdmin() && getId().equals(appUser.getId()) && getEmail().equals(appUser.getEmail()) && getUsername().equals(appUser.getUsername()) && getPassword().equals(appUser.getPassword()) && getMfaType().equals(appUser.getMfaType()) && getCreatedAt().equals(appUser.getCreatedAt()) && getCreatedBy().equals(appUser.getCreatedBy());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + Boolean.hashCode(isActive());
        result = 31 * result + Boolean.hashCode(isAdmin());
        result = 31 * result + getMfaType().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + getCreatedBy().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", admin=" + admin +
                ", mfaType='" + mfaType + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", id=" + id +
                '}';
    }
}
