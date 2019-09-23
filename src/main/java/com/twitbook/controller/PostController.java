package com.twitbook.controller;

import com.twitbook.domain.Board.Post;
import com.twitbook.security.CustomUserDetails;
import com.twitbook.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String viewPostCreateForm(ModelMap map) {
        map.addAttribute("post", new Post());
        return "postCreateForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") Post post, @ModelAttribute("account") CustomUserDetails account) {
        postService.insert(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable("id") Long postId, ModelMap map) {
        Optional<Post> optionalPost = postService.findById(postId);
        if(optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.increasePostViews();
            postService.flush();
            map.addAttribute("post", post);
            return "postView";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.GET)
    public String viewPostModifyForm(@PathVariable("id") Long postId, ModelMap map) {
        Optional<Post> post = postService.findById(postId);
        if(post.isPresent()) {
            map.addAttribute("post", post.get());
            return "postModifyForm";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modifyPost(@ModelAttribute("post") Post modifiedPost, @PathVariable("id") Long postId) {
        Optional<Post> optionalPost = postService.findById(postId);
        if(optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setPostTitle(modifiedPost.getPostTitle());
            post.setPostContent(modifiedPost.getPostContent());
            post.setPostUpdateDate(modifiedPost.getPostRegDate());
            postService.flush();
            return "redirect:/post/" + postId.toString();
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/{id}/delete")
    public String deletePost(@PathVariable("id") Long postId) {
        Post post = postService.delete(postId);
        return "redirect:/";
    }
}
