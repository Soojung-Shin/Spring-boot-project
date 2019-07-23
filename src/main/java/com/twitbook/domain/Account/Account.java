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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;

    @Column(length = 30, nullable = false)
    private String account_email;

    @Column(nullable = false)
    private String account_password;

    @Column(length = 20, nullable = false)
    private String account_name;

    @Column(length = 10, nullable = false)
    private String account_role;

    @CreationTimestamp
    private Date account_regDate;

    @UpdateTimestamp
    private Date account_updateDate;
}
