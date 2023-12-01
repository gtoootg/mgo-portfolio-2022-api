package com.mgoportfolio2022api.mgoportfolio2022api.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
  private final String jwtSigningKey = "secret";

  public String extractUsername(String token){
    Claims claims = Jwts.parser()
        .setSigningKey(jwtSigningKey)
        .parseClaimsJws(token)
        .getBody();

    return claims.getSubject();
  }

  public Date getExpiration(String token){
    Claims claims = Jwts.parser()
        .setSigningKey(jwtSigningKey)
        .parseClaimsJws(token)
        .getBody();

    return claims.getExpiration();
  }

  public boolean isTokenExpired(String token){
    return getExpiration(token).before(new Date());
  }

  public String generateToken(
      UserDetails userDetails){
    return Jwts.builder()
        .setSubject(userDetails.getUsername())
        .claim("authorities",userDetails.getAuthorities())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.HOURS.toMillis(24)))
        .signWith(SignatureAlgorithm.HS256,jwtSigningKey).compact();
  }

  public boolean isTokenValid(String token,UserDetails userDetails){
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }
}
