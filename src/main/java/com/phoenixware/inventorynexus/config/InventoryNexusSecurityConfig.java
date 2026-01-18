package com.phoenixware.inventorynexus.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class InventoryNexusSecurityConfig {

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM employees WHERE user_id = ?");
//
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id = ?");
//
//        return jdbcUserDetailsManager;
//
////        return new JdbcUserDetailsManager(dataSource);
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/orders").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/orders/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/orders").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/orders/**").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PATCH, "/orders/**").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/orders/**").hasRole("ADMIN"));
//
//        http.httpBasic(Customizer.withDefaults());
//
//        // disable CSRF or Cross Site Request Forgery... This will be a stateless API.
//        http.csrf(csrf -> csrf.disable());
//
//        return http.build();
//    }
}
