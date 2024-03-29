package com.mgoportfolio2022api.mgoportfolio2022api.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final JWTAthFilter jwtAuthFilter;
  private final UserDetailsService userDetailsService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
         http
             .cors().and()
             .csrf().disable()
             .authorizeHttpRequests()
             .requestMatchers("/api/auth/**").permitAll()
             .requestMatchers("/api/user").permitAll()
             .requestMatchers(HttpMethod.GET,"/api/albumposts").permitAll()
             .requestMatchers(HttpMethod.GET,"/api/common/**").permitAll()
             .anyRequest()
             .authenticated()
             .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
             .authenticationProvider(authenticationProvider())
             .addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class);

         return http.build();
  }
  @Bean
  public AuthenticationProvider authenticationProvider(){
    final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }
    @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();

    configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));

    configuration.setAllowedHeaders(List.of("*"));
    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    configuration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;
  }
}
