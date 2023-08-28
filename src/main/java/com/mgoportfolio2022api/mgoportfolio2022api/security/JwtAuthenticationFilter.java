package com.mgoportfolio2022api.mgoportfolio2022api.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import static org.springframework.security.config.Elements.JWT;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;

        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login","POST"));

        setUsernameParameter("userName");
        setPasswordParameter("password");

        this.setAuthenticationSuccessHandler((req,res,ex)->{
           String token = JWT.create()
                   .withIssuer("mgo")
                   .withClaim("userName",ex.getName())
                   .sign(Algorithm.HMAC256("secret"));
        });
    }

}
