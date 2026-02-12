package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Table (name = "role", schema = "public")
@Data
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany(mappedBy = "userRoles")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<AppUser> appUsers;

    @ManyToMany
    @JoinTable(
            name = "role_privilege",
            joinColumns = @JoinColumn(name = "fk_role_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_privilege_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Privilege> rolePrivileges;

    @Column(name = "name")
    private String name;
}
