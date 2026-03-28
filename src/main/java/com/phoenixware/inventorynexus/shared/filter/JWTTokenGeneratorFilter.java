package com.phoenixware.inventorynexus.shared.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/25/2026
 */
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Environment environment = getEnvironment();
            if (environment != null) {
                String secret = environment.getProperty("JWT_SECRET", "YourSuperCoolSecret!");

                SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
                String jwtToken = Jwts.builder().issuer("Inventory Nexus").subject("JWT Token")
                        .claim("username", authentication.getName())
                        .claim("authorities", authentication.getAuthorities().stream().map(
                                GrantedAuthority::getAuthority
                        ).collect(Collectors.joining(",")))
                        .issuedAt(new Date())
                        .expiration(new Date((new Date()).getTime() + 28800000))
                        .signWith(secretKey).compact();
                response.setHeader("Authorization", jwtToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/user");
    }
}
