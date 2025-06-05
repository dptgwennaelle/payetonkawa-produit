package com.payetonkawa.produitservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(authz ->authz
                .anyRequest().permitAll())
                .csrf().disable()
                .headers().frameOptions().disable();
        return http.build();
    }
}
