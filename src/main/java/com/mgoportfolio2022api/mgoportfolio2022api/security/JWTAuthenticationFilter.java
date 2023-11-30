package com.mgoportfolio2022api.mgoportfolio2022api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor;
public class JWTAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
    private  JWTGenerator tokenGenerator;
  @Autowired
  private  CustomUserDetailsService customUserDetailsService;

  private final JwtService jwtService;

  public JWTAuthenticationFilter() {
  }

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain
  ) throws ServletException, IOException {
    final  String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userEmail;
    if(authHeader == null||!authHeader.startsWith("Bearer ")){
      filterChain.doFilter(request, response);
      return;
    }

    jwt = authHeader.substring(7);
    userEmail = jwtService.extractUsername(jwt);




    String token = getJWTFromRequest(request);

    if(StringUtils.hasText(token) && tokenGenerator.validateToken(token)){


      String username = tokenGenerator.getUsernameFromJWT(token);
      System.out.println("username "+username);
      UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
      System.out.println("userdetail "+userDetails);
      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities());
      System.out.println("authenticationToken "+authenticationToken);
      authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    filterChain.doFilter(request,response);
  }

  private String getJWTFromRequest(HttpServletRequest request){
    String bearerToken = request.getHeader("Authorization");



    if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")){

      return bearerToken.substring(7,bearerToken.length());
    }
    return null;
  }
}
