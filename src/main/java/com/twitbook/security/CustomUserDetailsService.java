package com.twitbook.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CustomUserRepository customUserRepository;

    @Override
    public UserDetails loadUserByUsername(String accountEmail) throws UsernameNotFoundException {
        CustomUserDetails customUser = customUserRepository.findByAccountEmail(accountEmail);
        if (customUser == null) {
            throw new UsernameNotFoundException(accountEmail);
        }
        return customUser;
    }
}
