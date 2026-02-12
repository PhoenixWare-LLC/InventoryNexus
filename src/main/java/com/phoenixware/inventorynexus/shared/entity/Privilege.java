package com.phoenixware.inventorynexus.shared.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    private Set<Role> roles;

    @ManyToMany(mappedBy = "userPrivileges")
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;
        return isReadPrivilege() == privilege.isReadPrivilege() && isWritePrivilege() == privilege.isWritePrivilege() && isUpdatePrivilege() == privilege.isUpdatePrivilege() && isDeletePrivilege() == privilege.isDeletePrivilege() && getId().equals(privilege.getId()) && getName().equals(privilege.getName()) && getResourceName().equals(privilege.getResourceName());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getResourceName().hashCode();
        result = 31 * result + Boolean.hashCode(isReadPrivilege());
        result = 31 * result + Boolean.hashCode(isWritePrivilege());
        result = 31 * result + Boolean.hashCode(isUpdatePrivilege());
        result = 31 * result + Boolean.hashCode(isDeletePrivilege());
        return result;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "name='" + name + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", readPrivilege=" + readPrivilege +
                ", writePrivilege=" + writePrivilege +
                ", updatePrivilege=" + updatePrivilege +
                ", deletePrivilege=" + deletePrivilege +
                ", id=" + id +
                '}';
    }
}
