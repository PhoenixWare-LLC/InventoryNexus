package com.phoenixware.inventorynexus.shared.config;

import com.phoenixware.inventorynexus.shared.entity.AppUser;
import com.phoenixware.inventorynexus.shared.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    /**
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // Gather the roles
        appUser.getUserRoles().forEach(
                (role) ->
                        authorities.add(new SimpleGrantedAuthority(role.getName()))
        );

        appUser.getUserPrivileges().forEach(
                (privilege ) ->
                        authorities.add(new SimpleGrantedAuthority(privilege.getName()))
        );
        return new User(appUser.getUsername(),appUser.getPassword(), authorities);
    }
}
