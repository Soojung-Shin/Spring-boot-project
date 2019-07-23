package com.twitbook.service.impl;

import com.twitbook.domain.Account.Account;
import com.twitbook.domain.Account.AccountRepository;
import com.twitbook.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account insert(Account account) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        account.setAccountPassword(bCryptPasswordEncoder.encode(account.getAccountPassword()));
        account.setAccountRole("USER");
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(Long id) {
        Account account = accountRepository.findById(id).get();
        accountRepository.delete(account);
        return account;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }
}
