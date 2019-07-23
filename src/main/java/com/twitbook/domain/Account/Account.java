package com.twitbook.domain.Account;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "ACCOUNT_TB")
public class Account implements Serializable {

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
}
