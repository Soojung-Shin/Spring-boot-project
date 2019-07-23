package com.twitbook.service;

import com.twitbook.domain.Account.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account insert(Account account);
    Account update(Account account);
    Account delete(Long id);
    Account findById(Long id);
}
