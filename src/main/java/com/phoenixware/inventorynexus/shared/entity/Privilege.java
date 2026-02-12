package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "privilege", schema = "public")
@Data
public class Privilege {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;


    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

    @ManyToMany(mappedBy = "privileges")
    private List<User> users;

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
