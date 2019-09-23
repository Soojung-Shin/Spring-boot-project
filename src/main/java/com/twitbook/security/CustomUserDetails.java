package com.twitbook.security;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNT_TB")
public class CustomUserDetails implements UserDetails {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "account_email", length = 30, nullable = false)
    private String accountEmail;

    @Column(name = "account_password", nullable = false)
    private String accountPassword;

    @Column(name = "account_name", length = 20, nullable = false)
    private String accountName;

    @Column(name = "account_role", length = 10, nullable = false)
    private String accountRole;

    @Column(name = "account_regDate")
    @CreationTimestamp
    private Date accountRegDate;

    @Column(name = "account_updateDate")
    @UpdateTimestamp
    private Date accountUpdateDate;

    @Column(name = "account_profile_content", length = 100)
    private String accountProfileContent;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        //authorities.add(new SimpleGrantedAuthority(accountRole));
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return accountPassword;
    }

    @Override
    public String getUsername() {
        return accountEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
