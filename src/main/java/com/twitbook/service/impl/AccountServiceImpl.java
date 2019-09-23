package com.twitbook.service.impl;

import com.twitbook.domain.Account.AccountRepository;
import com.twitbook.security.CustomUserDetails;
import com.twitbook.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<CustomUserDetails> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public CustomUserDetails insert(CustomUserDetails account) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        account.setAccountPassword(bCryptPasswordEncoder.encode(account.getAccountPassword()));
        //account.setAccountRole("ROLE_USER");
        return accountRepository.save(account);
    }

    @Override
    public CustomUserDetails update(CustomUserDetails account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    public CustomUserDetails delete(Long id) {
        Optional<CustomUserDetails> account = accountRepository.findById(id);
        if(account.isPresent()) {
            accountRepository.delete(account.get());
            return account.get();
        } else {
            return null;
        }
    }

    @Override
    public Optional<CustomUserDetails> findById(Long id) {
        return accountRepository.findById(id);
    }
}
