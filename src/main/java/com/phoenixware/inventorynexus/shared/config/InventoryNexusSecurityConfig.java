package com.phoenixware.inventorynexus.shared.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ott.OneTimeTokenService;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManagerFactories;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authorization.EnableMultiFactorAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import java.time.Duration;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Slf4j
@Configuration
@EnableWebSecurity(debug = false)
@EnableMultiFactorAuthentication(authorities = {})
@RequiredArgsConstructor
public class InventoryNexusSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {

        // Set admin MFA for tasks that require additional privileges
        var adminMFA = AuthorizationManagerFactories.multiFactor()
                .requireFactor((f) -> f.passwordAuthority().validDuration(Duration.ofHours(4)))
                .requireFactor((f) -> f.ottAuthority().validDuration(Duration.ofMinutes(30)))
                .build();

        // Set basic MFA for endpoints to a full workday of 8 hours
        var basicMFA = AuthorizationManagerFactories.multiFactor()
                .requireFactor((f) -> f.passwordAuthority().validDuration(Duration.ofHours(8)))
                .requireFactor((f) -> f.ottAuthority().validDuration(Duration.ofHours(8)))
                .build();


        //TODO:
        // Change the access to request type to match that of the privilege system
        // Two flags will be, TRAINEE will always have read only access to endpoints
        // Admins that are marked as such on the user, have SuperAdmin privileges
        // Setup different requirements for different endpoints, with different security requirements.
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/about", "/contact", "/faq", "/error", "/ott/**")
                .permitAll()
                .requestMatchers( "/orders", "/orderitems", "/binlocations", "/parentproducts", "/shipments", "/shipmentpackages", "/transactions"
                        , "/orders/**", "/orderitems/**", "/binlocations/**", "/parentproducts/**", "/shipments/**", "/shipmentpackages/**", "/transactions/**")
                .access(basicMFA.hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN"))
                .requestMatchers("/admin/**", "/admin")
                .access(adminMFA.hasRole("ADMIN"))
                .requestMatchers("/users", "/users/**")
                .access((auth, context) -> {
                            Authentication authentication = auth.get();
                            Object principal = (AppUserDetailsService) authentication.getPrincipal();

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

                        }

                )
                .anyRequest().authenticated());

        // get that outta here.
        http.csrf(csrf -> csrf.disable());

        // to disable form login (API only)
        //http.formLogin(flc -> flc.disable());
        http.formLogin(Customizer.withDefaults());

        // To disable MFA via oneTimeTokenLogin
        // http.oneTimeTokenLogin(ott -> ott.disable());
        http.oneTimeTokenLogin(Customizer.withDefaults());

        // To disable http basic (very basic API authentication)
        // Disable below as I am going to implement OAuth2.0
        // http.httpBasic(hbc -> hbc.disable());
        http.httpBasic(Customizer.withDefaults());


        return http.build();
    }

    @Bean
    public OneTimeTokenService oneTimeTokenService() {
        PinOneTimeTokenService service = new PinOneTimeTokenService();
        service.setTokenExpiresIn(Duration.ofMinutes(3));
        return service;
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
