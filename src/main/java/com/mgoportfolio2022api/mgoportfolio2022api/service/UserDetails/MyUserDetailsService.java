package com.mgoportfolio2022api.mgoportfolio2022api.service.UserDetails;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.UserRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public MyUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));
        return new MyUserDetails(user);
    }
}
