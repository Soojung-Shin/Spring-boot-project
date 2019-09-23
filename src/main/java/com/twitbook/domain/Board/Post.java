package com.twitbook.domain.Board;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "POST_TB")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    //    @Column(name = "post_title", length = 50, nullable = false)
    @Column(name = "post_title", length = 50)
    private String postTitle;

//    @Column(name = "post_content", length = 1000, nullable = false)
    @Column(name = "post_content", length = 1000)
    private String postContent;

//    @Column(name = "account_id", nullable = false)
//    @Column(name = "account_id")
//    private Long accountId;

    @Column(name = "post_regDate")
    @CreationTimestamp
    private Date postRegDate;

    @Column(name = "post_updateDate")
    @UpdateTimestamp
    private Date postUpdateDate;

    @Column(name = "post_views")
    private int postViews;

    @Column(name = "post_like")
    private int postLike;

    public void increasePostViews() {
        postViews += 1;
    }
}
