package org.example.demospring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Harideep Reddy Boothpur
 * created  3/27/26 4:25 PM
 */

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
        http
                // Disable CSRF for testing POST via Postman
                .csrf(csrf -> csrf.disable())

                // Permit all requests to /auth/**
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/api/products/**").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )

                // Optional: basic auth for other endpoints
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}