package com.twitbook.service;

import com.twitbook.security.CustomUserDetails;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<CustomUserDetails> findAll();
    CustomUserDetails insert(CustomUserDetails account);
    CustomUserDetails update(CustomUserDetails account);
    CustomUserDetails delete(Long id);
    Optional<CustomUserDetails> findById(Long id);
}
