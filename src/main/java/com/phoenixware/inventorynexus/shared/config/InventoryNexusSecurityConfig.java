package com.phoenixware.inventorynexus.shared.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ott.OneTimeTokenService;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authorization.AuthorizationManagerFactories;
import org.springframework.security.authorization.AuthorizationManagerFactory;
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
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import java.time.Duration;

@Slf4j
@Configuration
@EnableWebSecurity()
@EnableMultiFactorAuthentication(authorities = {})
public class InventoryNexusSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

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


        // Setup different requirements for different endpoints, with different security requirements.
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/about", "/contact", "/faq", "/error", "/ott/**")
                .permitAll()
                .requestMatchers("/orders", "/orderitems", "/binlocations", "/parentproducts", "/shipments", "/shipmentpackages", "/transactions"
                        , "/orders/**", "/orderitems/**", "/binlocations/**", "/parentproducts/**", "/shipments/**", "/shipmentpackages/**", "/transactions/**").access(basicMFA.hasRole("USER"))
                .requestMatchers("/admin/**", "/admin").access(adminMFA.hasRole("ADMIN"))
                .anyRequest().authenticated());


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
        UserDetails user = User.withUsername("harold").password(password).roles("ADMIN", "USER").build();
        return new InMemoryUserDetailsManager(user);
    }

    // Make sure password has not been compromised.
    @Bean
    CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

//    @Bean
//    AuthorizationManagerFactory<Object> authz() {
//        return AuthorizationManagerFactories.multiFactor()
//                .requireFactors(
//                        FactorGrantedAuthority.PASSWORD_AUTHORITY,
//                        FactorGrantedAuthority.OTT_AUTHORITY
//                ).build();
//    }

}
