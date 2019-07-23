package com.twitbook.service;

import com.twitbook.domain.Account.Account;
import com.twitbook.domain.Account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Account account = accountRepository.findByAccountEmail(loginId);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        User user = new User(account.getAccountEmail(), "{bcrypt}" + account.getAccountPassword(), grantedAuthorityList);
        return user;
    }
}
