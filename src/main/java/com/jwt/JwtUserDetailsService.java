/*package com.jwt;

import com.repositories.UserRepository;
import com.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginEmail) throws UsernameNotFoundException {
        var customUser = userRepository.findByEmail(loginEmail);
        if(customUser == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new SecurityUser(customUser);
    }
}*/
