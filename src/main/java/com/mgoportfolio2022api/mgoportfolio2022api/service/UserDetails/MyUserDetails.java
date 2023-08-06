package com.mgoportfolio2022api.mgoportfolio2022api.service.UserDetails;

import com.mgoportfolio2022api.mgoportfolio2022api.model.UserEntity;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;

import static java.util.Arrays.stream;

@Getter
public class MyUserDetails extends User {

    private final UserEntity user;

    public MyUserDetails(UserEntity user) {
        super(user.getUserName(), user.getPassword(),
                Arrays.asList("User").stream().map(
                        role -> new SimpleGrantedAuthority((role))).toList());
        this.user = user;
    }
}
