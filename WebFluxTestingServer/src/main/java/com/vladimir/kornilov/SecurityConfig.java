package com.vladimir.kornilov;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securitygWebFilterChain(
            ServerHttpSecurity http) {
        // Disable default security.
        http.httpBasic().disable();
        http.formLogin().disable();
        http.csrf().disable();
        http.logout().disable();

        // Disable authentication for `/concatenate/**` routes.
        http.authorizeExchange().pathMatchers("/concatenate/**").permitAll();
        http.authorizeExchange().anyExchange().authenticated();
        return http.build();
    }
}
