package com.phoenixware.inventorynexus.shared.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ott.OneTimeTokenService;
import org.springframework.security.authorization.AuthorizationManagerFactories;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authorization.EnableMultiFactorAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.FactorGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.time.Duration;

@Slf4j
@Configuration
@EnableWebSecurity(debug = true)
@EnableMultiFactorAuthentication(
        authorities = {
                FactorGrantedAuthority.PASSWORD_AUTHORITY,
                FactorGrantedAuthority.OTT_AUTHORITY
        }
)
public class InventoryNexusSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        // Admin endpoint, ensure user has entered password within 30 minutes... makes sense.
        var adminMFA30Minute = AuthorizationManagerFactories.multiFactor()
                .requireFactors(
                        FactorGrantedAuthority.PASSWORD_AUTHORITY,
                        FactorGrantedAuthority.OTT_AUTHORITY
                )
                .requireFactor(
                        factor -> factor
                                .passwordAuthority()
                                .validDuration(Duration.ofMinutes(30))
                )
                .build();

        // For secure endpoints, ensure the user has entered password within 1 hour.
        var mfa1Hour = AuthorizationManagerFactories.multiFactor()
                .requireFactors(
                        FactorGrantedAuthority.PASSWORD_AUTHORITY,
                        FactorGrantedAuthority.OTT_AUTHORITY
                )
                .requireFactor(factor -> factor
                        .passwordAuthority()
                        .validDuration(Duration.ofHours(1)))
                .build();

        // Setup different requirements for different endpoints, with different security requirements.
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/about", "/contact", "/faq", "/error", "/ott/sent")
                .permitAll()
                .requestMatchers("/orders", "/orderitems", "/binlocations", "/parentproducts", "/shipments", "/shipmentpackages", "/transactions"
                        , "/orders/**", "/orderitems/**", "/binlocations/**", "/parentproducts/**", "/shipments/**", "/shipmentpackages/**", "/transactions/**")
                .access(mfa1Hour.authenticated())
                .requestMatchers("/admin/**").access(adminMFA30Minute.hasRole("ADMIN")));


        // to disable form login (API only)
        //http.formLogin(flc -> flc.disable());
        http.formLogin(Customizer.withDefaults());

        // To disable MFA via oneTimeTokenLogin
        // http.oneTimeTokenLogin(ott -> ott.disable());
        http.oneTimeTokenLogin(Customizer.withDefaults());

        // To disable http basic (very basic API authentication)
        // http.httpBasic(hbc -> hbc.disable());
        http.httpBasic(Customizer.withDefaults());


        return http.build();
    }

    // Override default OneTimeTokenService
    @Bean
    public OneTimeTokenService oneTimeTokenService() {
        PinOneTimeTokenService service = new PinOneTimeTokenService();
        service.setTokenExpiresIn(Duration.ofMinutes(3));
        return service;
    }

    // Must have for method below
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Just for testing. My user of Harold with the password of f!nch
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder encoder) {
        String password = encoder.encode("finch");
        UserDetails user = User.withUsername("harold").password(password).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user);
    }

}
