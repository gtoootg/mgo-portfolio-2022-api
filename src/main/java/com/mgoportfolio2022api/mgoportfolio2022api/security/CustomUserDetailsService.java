package com.mgoportfolio2022api.mgoportfolio2022api.security;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.UserRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.user.Role;
import com.mgoportfolio2022api.mgoportfolio2022api.model.user.UserEntity;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


  private UserRepository userRepository;

  @Autowired
  public CustomUserDetailsService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    return new User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
  }

  private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
    return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
  }

}
