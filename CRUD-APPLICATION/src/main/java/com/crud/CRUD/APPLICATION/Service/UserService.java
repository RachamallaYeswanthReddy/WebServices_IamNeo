package com.crud.CRUD.APPLICATION.Service;

import com.crud.CRUD.APPLICATION.Entity.User;
import com.crud.CRUD.APPLICATION.Repository.UserRepository;
import com.crud.CRUD.APPLICATION.util.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    User user;
    private final PasswordEncoder passwordEncoder;
    public UserService(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }
    public User saveUser(User user){
        user.setPassword(this.passwordEncoder.encode(user.getPassword())); // makes encoded
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> new UserPrincipal(user))
                .orElseThrow(()-> new UsernameNotFoundException(("User Not found"))) ;
    }
}
