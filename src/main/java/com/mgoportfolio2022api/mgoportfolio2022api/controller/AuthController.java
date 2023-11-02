package com.mgoportfolio2022api.mgoportfolio2022api.controller;


import com.mgoportfolio2022api.mgoportfolio2022api.dao.RoleRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.UserRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.user.Role;
import com.mgoportfolio2022api.mgoportfolio2022api.model.user.UserEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.security.JWTGenerator;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user.AuthResponseDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user.LoginDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user.RegisterDTO;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


  private AuthenticationManager authenticationManager;
  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private PasswordEncoder passwordEncoder;
  private JWTGenerator jwtGenerator;
  @Autowired
  public AuthController(
      AuthenticationManager authenticationManager,
      UserRepository userRepository,
      RoleRepository roleRepository,
      PasswordEncoder passwordEncoder,
      JWTGenerator jwtGenerator
    )
  {
    this.authenticationManager =authenticationManager;
    this.userRepository=userRepository;
    this.roleRepository=roleRepository;
    this.passwordEncoder=passwordEncoder;
    this.jwtGenerator = jwtGenerator;
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

  @PostMapping("/login")
  public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = jwtGenerator.generateToken(authentication);

    return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
  }
}
