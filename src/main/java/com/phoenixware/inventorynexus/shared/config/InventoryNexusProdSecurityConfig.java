package com.phoenixware.inventorynexus.shared.config;

import com.phoenixware.inventorynexus.shared.exception.CustomBasicAuthenticationEntryPoint;
import com.phoenixware.inventorynexus.shared.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Profile("prod")
@Slf4j
@Configuration
@EnableWebSecurity(debug = false)
@RequiredArgsConstructor
public class InventoryNexusProdSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {

        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();

        //TODO:
        // Change the access to request type to match that of the privilege system
        // Two flags will be, TRAINEE will always have read only access to endpoints
        // Admins that are marked as such on the user, have SuperAdmin privileges
        // Setup different requirements for different endpoints, with different security requirements.
        http.authorizeHttpRequests((requests) -> requests
                // public endpoints
                .requestMatchers(
                        "/", "/about", "/contacts", "/faq", "/error", "/ott/**"
                ).permitAll()

                // employee endpoints
                .requestMatchers(
                        "/orders", "/orders/**",
                        "/orderitems", "/orderitems/**",
                        "/binlocations", "/binlocations/**",
                        "/parentproducts", "/parentproducts/**",
                        "/shipments", "/shipments/**",
                        "/shipmentpackages", "/shipmentpackages/**",
                        "/transactions", "/transactions/**"
                ).hasAnyRole(
                        "EMPLOYEE",
                        "MANAGER",
                        "ADMIN"
                )

                // api calls
                .requestMatchers(
                        "/api/**"
                ).hasAnyRole(
                        "EMPLOYEE",
                        "MANAGER",
                        "ADMIN"
                )

                // admin panels
                .requestMatchers("/admin/**", "/admin")
                .hasAnyRole(
                        "ADMIN"
                )

                // user self management. or admin user administration
                .requestMatchers("/users", "/users/**")
                .access(userSelfAccessOrAdmin())

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
                    corsConfiguration.setMaxAge(3600L);
                    return corsConfiguration;
                }
            });
        });

        // TODO: add feature in here for session timeout based on endpoints/role

        // Documentation states that for any Javascript or Typescript UI applications, .withHttpOnlyFalse must be called, as the frontend UI would not be able to see the token.
        http.csrf(csrf ->
                csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler));

        http.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);


        http.sessionManagement(smc -> smc.
                sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .sessionFixation().changeSessionId()                                         // mitigate session fixation attacks
                .maximumSessions(2).maxSessionsPreventsLogin(true)// set max sessions to 2
        );

        // require https
        http.redirectToHttps(Customizer.withDefaults());

        http.formLogin(Customizer.withDefaults());

        http.httpBasic(hbc -> hbc
                .authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));

        return http.build();
    }

    private AuthorizationManager<RequestAuthorizationContext> userSelfAccessOrAdmin() {
        return (auth, context) -> {
            Authentication authentication = auth.get();
            Object principal = authentication.getPrincipal();

            if (!(principal instanceof AppUserDetails appUserDetails)) {
                return new AuthorizationDecision(false);
            }
            String path = context.getRequest().getRequestURI();
            String pathUserId = path.substring(path.lastIndexOf("/") + 1);

            String httpMethod = context.getRequest().getMethod();

            boolean isAdmin = appUserDetails.getAppUser().isAdmin();
            if (!isAdmin) {
                isAdmin = appUserDetails.getAppUser().getUserRoles()
                        .stream()
                        .anyMatch(role -> role.getName().equals("ROLE_ADMIN"));
            }

            UUID currentUserId = appUserDetails.getAppUser().getId();


            return new AuthorizationDecision(isAdmin || (currentUserId.toString().equals(pathUserId) && !httpMethod.equals("DELETE")));
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

}
