package com.phoenixware.inventorynexus.shared.config;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.FactorGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/19/2026
 */
@Component
@RequiredArgsConstructor
public class AppUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final AppUserDetailsService appUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        UserDetails userDetails = appUserDetailsService.loadUserByUsername(username);

        if (passwordEncoder.matches(pwd, userDetails.getPassword())) {
            // additional logic would go here.
            Collection<GrantedAuthority> authorities = new LinkedHashSet(this.authoritiesMapper.mapAuthorities(userDetails.getAuthorities()));
            authorities.add(FactorGrantedAuthority.fromAuthority("FACTOR_PASSWORD"));
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            return result;
        } else {
            throw new BadCredentialsException("Invalid username or password!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}