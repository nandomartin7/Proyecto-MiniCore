package com.example.MiniCore.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
        return http
                .csrf(csrf -> csrf.disable())  //Deshabilita CSRF para facilitar la API REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/empleado/**").permitAll() //Protege las rutas de
                        .requestMatchers("/departamento/**").permitAll()  //Protege las rutas de contrato
                        .requestMatchers("/gasto/**").permitAll()  //Protege las rutas de reporte
                        .anyRequest().permitAll()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))  //Indica que no se manejarán sesiones de usario en el servidor
                .logout(logout ->logout.permitAll()) //Permite logout
                .build();
    }
}
