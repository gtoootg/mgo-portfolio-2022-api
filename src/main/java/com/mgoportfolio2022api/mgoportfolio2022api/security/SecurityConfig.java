package com.mgoportfolio2022api.mgoportfolio2022api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // ログインが必須なページを修正
        http.authorizeRequests(auth -> {

            auth.anyRequest().permitAll();

//            auth.antMatchers("/post").authenticated();
//            http.authorizeHttpRequests(authz -> authz
//                    // h2-console を利用する場合は必要
//                    // .antMatchers("/h2-console/**").permitAll()
//                    .requestMatchers(HttpMethod.POST,"/api/login").permitAll()
//                    .anyRequest().authenticated()
//            );
        });
        http.cors().configurationSource(corsConfigurationSource());
        http.addFilter(new JwtAuthenticationFilter(authenticationManager(http.getSharedObject(AuthenticationConfiguration.class))));
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        cors.setAllowedMethods(Arrays.asList("GET","POST"));
        cors.setAllowedHeaders(Arrays.asList("*"));
        cors.setAllowCredentials(true);
        cors.addExposedHeader("X-AUTH-TOKEN");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",cors);
        return source;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user = User.withUsername("misaka")
                .password(
                        PasswordEncoderFactories
                                .createDelegatingPasswordEncoder()
                                .encode("mikoto"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

}
