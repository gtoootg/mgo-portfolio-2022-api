package com.mgoportfolio2022api.mgoportfolio2022api.controller;


import com.mgoportfolio2022api.mgoportfolio2022api.dao.RoleRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.UserRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.user.Role;
import com.mgoportfolio2022api.mgoportfolio2022api.model.user.UserEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.security.JwtUtils;
import com.mgoportfolio2022api.mgoportfolio2022api.security.UserDetailsService;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user.AuthenticationRequest;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user.RegisterDTO;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtils jwtUtils;

  @PostMapping("/authenticate")
  public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request){
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
    );
    final UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
    if(user!=null){
      return ResponseEntity.ok(jwtUtils.generateToken(user));
    }
    return ResponseEntity.status(400).body("some error occured");
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto){
    if(userRepository.existsByUsername(registerDto.getUsername())){
      return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
    }

    UserEntity user = new UserEntity();
    user.setUsername(registerDto.getUsername());
    user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

    Role roles = roleRepository.findByName("USER").get();
    user.setRoles(Collections.singletonList(roles));

    userRepository.save(user);

    return new ResponseEntity<>("User register success", HttpStatus.OK);
  }
}
