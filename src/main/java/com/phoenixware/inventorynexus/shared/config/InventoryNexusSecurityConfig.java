package com.phoenixware.inventorynexus.shared.config;

import com.phoenixware.inventorynexus.shared.exception.auth.CustomAccessDeniedHandler;
import com.phoenixware.inventorynexus.shared.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Profile("!prod")
@Slf4j
@Configuration
@EnableWebSecurity(debug = false)
@RequiredArgsConstructor
public class InventoryNexusSecurityConfig {

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.introspection-uri}")
    private String introspectionUri;

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-secret}")
    private String clientSecret;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();


        //TODO:
        // Change the access to request type to match that of the privilege system
        // Two flags will be, TRAINEE will always have read only access to endpoints
        // Admins that are marked as such on the user, have SuperAdmin privileges
        // Setup different requirements for different endpoints, with different security requirements.
        http.authorizeHttpRequests((requests) -> requests
                // public endpoints
                .requestMatchers(
                        "/",
                        "/abouts", "/abouts/**",
                        "/contacts", "/contacts/**",
                        "/faqs", "/faqs/**",
                        "/error", "/error/**"
                ).permitAll()

                //Employee Endpoints
                .requestMatchers("/orders", "/orders/**").hasAuthority("orders")
                .requestMatchers("/order-items", "/order-items/**").hasAuthority("order-items")
                .requestMatchers("/bin-locations", "/bin-locations/**").hasAuthority("bin-locations")
                .requestMatchers("/parent-products", "/parent-products/**").hasAuthority("parent-products")
                .requestMatchers("/shipments", "/shipments/**").hasAuthority("shipments")
                .requestMatchers("/shipment-packages", "/shipment-packages/**").hasAuthority("shipment-packages")
                .requestMatchers("/transactions", "/transactions/**").hasAuthority("transactions")

                // admin panels
                .requestMatchers("/admin/**", "/admin")
                .hasAuthority("admin")

                // user self management. or admin user administration
                .requestMatchers("/users", "/users/**")
                .hasAuthority("admin")

                // everything else requires authentication (default deny)
                .anyRequest().authenticated());


        http.cors(cors -> {
            cors.configurationSource(new CorsConfigurationSource() {
                @Override
                public @Nullable CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                    corsConfiguration.setAllowCredentials(true);
                    corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                    corsConfiguration.setExposedHeaders(Arrays.asList("Authorization"));
                    corsConfiguration.setMaxAge(3600L);
                    return corsConfiguration;
                }
            });
        });

        // Documentation states that for any Javascript or Typescript UI applications, .withHttpOnlyFalse must be called, as the frontend UI would not be able to see the token.
        http.csrf(csrf ->
                csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
                        .ignoringRequestMatchers(
                                "/",
                                "/abouts", "/abouts/**",
                                "/contacts", "/contacts/**",
                                "/faqs", "/faqs/**",
                                "/error", "/error/**"));

        http.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);

        http.sessionManagement(smc -> smc.
                sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );


        //again, this works, and saves network bandwidth. However, makes key rotation more painful.
//        http.oauth2ResourceServer(rsc -> rsc
//                .jwt(jwtConfigurer -> jwtConfigurer
//                        .jwtAuthenticationConverter(jwtAuthenticationConverter)));

        http.oauth2ResourceServer(rsc -> rsc.
                opaqueToken(otc -> otc.
                        authenticationConverter(new KeycloakOpaqueRoleConverter())
                        .introspectionUri(this.introspectionUri)
                        .introspectionClientCredentials(this.clientId, this.clientSecret)));

        http.exceptionHandling(ehc -> ehc.
                accessDeniedHandler(new CustomAccessDeniedHandler())
        );


        return http.build();
    }

}
