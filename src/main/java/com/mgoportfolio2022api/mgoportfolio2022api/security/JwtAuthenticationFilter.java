package com.mgoportfolio2022api.mgoportfolio2022api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.UserRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.UserEntity;
import com.sun.security.auth.UserPrincipal;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private UserRepository userRepository;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, UserRepository userRepository){
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login","POST"));

        setUsernameParameter("userName");
        setPasswordParameter("password");

        this.setAuthenticationSuccessHandler((req,res,ex)->{

            Optional<UserEntity> user = userRepository.findByUserName(ex.getName());// UserPrincipalは実際のUserの実装に依存します
           String token = JWT.create()
                   .withIssuer("mgo")
                   .withClaim("userName",ex.getName())
                   .sign(Algorithm.HMAC256("secret"));
            res.setContentType(MediaType.APPLICATION_JSON_VALUE); // JSONレスポンスを設定
            res.getWriter().write("{\"token\":\"" + token + "\", \"id\":\"" + user.get().getUserId() + "\"}"); // JSON形式のトークンをレスポンスに書き込む
            res.setStatus(200);
        });

        this.setAuthenticationFailureHandler((req,res,ex) -> {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            ServletInputStream servletInputStream = request.getInputStream();
            LoginForm form = new ObjectMapper().readValue(request.getInputStream(),LoginForm.class);
            return this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(form.userName,form.password,new ArrayList<>())
            );
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

}
