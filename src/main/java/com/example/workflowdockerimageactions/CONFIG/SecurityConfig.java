package com.example.workflowdockerimageactions.CONFIG;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf ->{
            csrf.ignoringRequestMatchers("/*");
        })
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/*")
                            .permitAll();
                })
                .build();
    }
}
