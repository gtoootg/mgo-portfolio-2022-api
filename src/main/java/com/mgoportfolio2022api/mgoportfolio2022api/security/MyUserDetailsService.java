package com.mgoportfolio2022api.mgoportfolio2022api.security;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.UserRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String encodedPassword = passwordEncoder.encode(user.get().getPassword());
//        System.out.println( encodedPassword);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.get().getUserName())
                .password(encodedPassword)
                .roles("USER") // ユーザーの権限情報を設定
                .build();
    }
}
