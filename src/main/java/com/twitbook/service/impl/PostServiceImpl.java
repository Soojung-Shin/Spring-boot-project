package com.twitbook.service.impl;

import com.twitbook.domain.Board.Post;
import com.twitbook.domain.Board.PostRepository;
import com.twitbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void flush() {postRepository.flush();}

    @Override
    public List<Post> getAllList() {
        return postRepository.findAllByOrderByPostIdDesc();
    }

    @Override
    public Post insert(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post delete(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()) {
            postRepository.delete(post.get());
            return post.get();
        } else {
            return null;
        }
    }

    @Override
    public Optional<Post> findById(Long postId) {
        return postRepository.findById(postId);
    }
}
