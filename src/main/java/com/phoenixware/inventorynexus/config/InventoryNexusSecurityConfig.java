package com.phoenixware.inventorynexus.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

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

    //        return new JdbcUserDetailsManager(dataSource);
//    }
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/about", "/contact","/faq", "/error").permitAll()
                .requestMatchers("/orders", "/orderitems", "/binlocations","/parentproducts", "/shipments", "/shipmentpackages", "/transactions"
                , "/orders/**", "/orderitems/**", "/binlocations/**", "/parentproducts/**", "/shipments/**", "/shipmentpackages/**", "/transactions/**").authenticated());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
