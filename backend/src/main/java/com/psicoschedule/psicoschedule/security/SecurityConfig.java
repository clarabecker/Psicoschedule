package com.psicoschedule.psicoschedule.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private SecurityFilter filterAutenticacao;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/profissional/cadastro").permitAll()
                    .requestMatchers("/profissional/login").permitAll()
                    .requestMatchers("/paciente/cadastro").permitAll()
                    .requestMatchers("/paciente/login").permitAll();
                auth.anyRequest().authenticated();
            })
            .addFilterBefore(filterAutenticacao, BasicAuthenticationFilter.class);
        return http.build();
    }
}
