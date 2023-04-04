package com.services.impls;

import com.domains.User;
import com.security.SecurityUser;
import com.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService service;

    public UserDetailsServiceImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = service.findByEmail(s);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new SecurityUser(user);
    }
}
