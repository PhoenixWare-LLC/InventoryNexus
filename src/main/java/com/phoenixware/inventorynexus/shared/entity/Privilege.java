package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "privilege", schema = "public")
@Data
public class Privilege {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany(mappedBy = "rolePrivileges")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> roles;

    @ManyToMany(mappedBy = "userPrivileges")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<AppUser> appUsers;

    @Column(name =  "name", nullable = false, length = 50)
    private String name;

    @Column(name = "resource_name", nullable = false, length = 50)
    private String resourceName;

    @Column(name = "read_privilege", nullable = false)
    private boolean readPrivilege = false;

    @Column(name = "write_privilege", nullable = false)
    private boolean writePrivilege = false;

    @Column(name = "update_privilege", nullable = false)
    private boolean updatePrivilege = false;

    @Column(name = "delete_privilege", nullable = false)
    private boolean deletePrivilege = false;
}
