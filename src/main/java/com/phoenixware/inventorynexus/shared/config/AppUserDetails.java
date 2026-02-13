package com.phoenixware.inventorynexus.shared.config;

import com.phoenixware.inventorynexus.shared.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

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
