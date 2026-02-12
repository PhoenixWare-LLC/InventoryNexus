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

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AppUserDetailService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    /**
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUserWithRoles = appUserRepository.findByUsernameWithRoles(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));

        AppUser appUserWithPrivileges =  appUserRepository.findByIdWithPrivileges(appUserWithRoles.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + appUserWithRoles.getId()));

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // Gather the roles
        appUserWithRoles.getUserRoles().forEach(
                (role) ->
                        authorities.add(new SimpleGrantedAuthority(role.getName()))
        );

        appUserWithPrivileges.getUserPrivileges().forEach(
                (privilege ) ->
                        authorities.add(new SimpleGrantedAuthority(privilege.getName()))
        );
        return new User(appUserWithRoles.getUsername(),appUserWithRoles.getPassword(), authorities);
    }
}
