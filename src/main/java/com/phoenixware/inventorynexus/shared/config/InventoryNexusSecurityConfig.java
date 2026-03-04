package com.phoenixware.inventorynexus.shared.config;

import com.phoenixware.inventorynexus.shared.exception.CustomBasicAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.AuthorizationManagerFactories;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import java.time.Duration;
import java.util.UUID;

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

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {

        // Set admin MFA for tasks that require additional privileges
        var adminMFA = AuthorizationManagerFactories.multiFactor()
                .requireFactor((f) -> f
                        .passwordAuthority()
                        .validDuration(Duration.ofDays(30)))
                .build();

        // Set basic MFA for endpoints to a full workday of 8 hours
        var basicMFA = AuthorizationManagerFactories.multiFactor()
                .requireFactor((f) -> f
                        .passwordAuthority()
                        .validDuration(Duration.ofDays(60)))
                .build();

        var httpBasic = AuthorizationManagerFactories.multiFactor()
                .requireFactor((f) -> f.passwordAuthority()).build();


        //TODO:
        // Change the access to request type to match that of the privilege system
        // Two flags will be, TRAINEE will always have read only access to endpoints
        // Admins that are marked as such on the user, have SuperAdmin privileges
        // Setup different requirements for different endpoints, with different security requirements.
        http.authorizeHttpRequests((requests) -> requests
                // public endpoints
                .requestMatchers(
                        "/", "/about", "/contact", "/faq", "/error", "/ott/**"
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
                ).access(
                        // require basic mfa, longer credential validity
                        basicMFA.
                                hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                )

                // api calls
                .requestMatchers(
                        "/api/**"
                ).access(
                        httpBasic
                                .hasAnyRole(
                                        "EMPLOYEE",
                                        "MANAGER",
                                        "ADMIN"
                                )
                )

                // admin panels
                .requestMatchers("/admin/**", "/admin")
                .access(adminMFA.hasRole("ADMIN"))

                // user self management. or admin user administration
                .requestMatchers("/users", "/users/**")
                .access(userSelfAccessOrAdmin())

                // everything else requires authentication (default deny)
                .anyRequest().authenticated());

        // TODO: add feature in here for session timeout based on endpoints/role

        http.sessionManagement(smc -> smc
                .sessionFixation().changeSessionId()                                         // mitigate session fixation attacks
                .maximumSessions(2).maxSessionsPreventsLogin(true)              // set max sessions to 2
        );

        // get that outta here.
        http.csrf(csrf -> csrf.disable());

        // to disable form login (API only)
        //http.formLogin(flc -> flc.disable());
        http.formLogin(Customizer.withDefaults());

        // To disable http basic (very basic API authentication)
        // Disable below as I am going to implement OAuth2.0
//        // http.httpBasic(hbc -> hbc.disable());
        http.httpBasic(hbc -> hbc
                .authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint())
        );


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
