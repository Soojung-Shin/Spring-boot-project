package com.twitbook.domain.Account;

import com.twitbook.security.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<CustomUserDetails, Long> {
    Optional<CustomUserDetails> findById(Long id);
}
