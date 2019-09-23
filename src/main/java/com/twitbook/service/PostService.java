package com.twitbook.service;

import com.twitbook.domain.Board.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void flush();
    List<Post> getAllList();
    Post insert(Post post);
    Post delete(Long postId);
    Optional<Post> findById(Long postId);
}
