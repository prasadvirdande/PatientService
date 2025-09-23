package com.PatientService.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
   @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.
               csrf(csrf->csrf.disable())
               .headers(headers -> headers.frameOptions(frameOptions->frameOptions.disable()))
               .authorizeHttpRequests(auth->auth
                       .requestMatchers("h2-console/**").permitAll()
                       .anyRequest().permitAll());

       return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
