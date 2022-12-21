package com.exampl.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfig {


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{

        http.cors().and().csrf().disable()
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/login" , "/register").permitAll()
                                .anyRequest().authenticated()
                                ).httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder();
    }



    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


}
