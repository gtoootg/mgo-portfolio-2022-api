package com.mgoportfolio2022api.mgoportfolio2022api.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgoportfolio2022api.mgoportfolio2022api.model.UserEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.UserDetails.MyUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Slf4j
public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public UserAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;

        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));

        this.setAuthenticationSuccessHandler((req,res,ex)->{
            res.setStatus(200);
            MyUserDetails user =  (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            res.getWriter().write((new ObjectMapper()).writeValueAsString(user.getUser()));
        });

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        try {
            // リクエストのデータを LoginForm として取り出す
            LoginForm principal = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);
            // 認証処理を実行する
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(principal.getUsername(), principal.getPassword())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

}
