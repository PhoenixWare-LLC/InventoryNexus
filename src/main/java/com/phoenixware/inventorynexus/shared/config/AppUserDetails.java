package com.phoenixware.inventorynexus.shared.config;

import com.phoenixware.inventorynexus.shared.entity.AppUser;
import com.phoenixware.inventorynexus.shared.entity.Privilege;
import com.phoenixware.inventorynexus.shared.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.Hibernate;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
@Getter
@AllArgsConstructor
public class AppUserDetails implements UserDetails {
    private final AppUser appUser;
    private final Collection<? extends GrantedAuthority> authorities;


    public boolean hasPrivilege(String resource, String action) {
        if (resource == null || action == null || appUser == null) {
            return false;
        }

        String sanatizedResource = resource.trim().toLowerCase();
        String sanatizedAction = action.trim().toLowerCase();

        Set<Privilege> allPrivileges = getAllPrivileges();

        for (Privilege privilege : allPrivileges) {
            if (privilege.getResourceName() != null &&
                    sanatizedResource.equals(privilege.getResourceName().trim().toLowerCase())) {
                return switch (sanatizedAction) {
                    case "read" -> Boolean.TRUE.equals(privilege.getRead());
                    case "update" -> Boolean.TRUE.equals(privilege.getUpdate());
                    case "create" -> Boolean.TRUE.equals(privilege.getCreate());
                    case "delete" -> Boolean.TRUE.equals(privilege.getDelete());
                    default -> false;
                };
            }
        }
        return false;
    }

    public Set<Privilege> getAllPrivileges() {
        Set<Privilege> privileges = new HashSet<>();

        if (appUser.getUserPrivileges() != null) {
            privileges.addAll(appUser.getUserPrivileges());
        }

        if (appUser.getUserRoles() != null) {
            for (Role role : appUser.getUserRoles()) {
                Hibernate.initialize(role.getRolePrivileges());
                if (role.getRolePrivileges() != null) {
                    privileges.addAll(role.getRolePrivileges());
                }
            }
        }
        return privileges;
    }
    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    /**
     * @return
     */
    @Override
    public @Nullable String getPassword() {
        return appUser.getPassword();
    }

    /**
     * @return
     */
    @Override
    public String getUsername() {
        return appUser.getUsername();
    }

    // TODO: create a account expire after certain length of time since last login.
    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // TODO: create n lock in the User Table.
    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // TODO: create a admin expire field within the User Table
    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return appUser.isActive();
    }
}
