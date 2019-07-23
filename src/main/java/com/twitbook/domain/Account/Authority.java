package com.twitbook.domain.Account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "AUTHORITY_TB")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_email")
    private String accountEmail;

    @Column(name = "authority_name", length = 30, nullable = false)
    private String authorityName;
}
