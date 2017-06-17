package com.github.dregheap.controller;

import com.github.dregheap.model.Post;
import com.github.dregheap.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping(path = "/api/v1/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllPosts() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity getAllPagedPosts(Pageable pageable) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createPost(@RequestBody Post post) {
        return new ResponseEntity<Post>(postService.createPost(post), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updatePost(@RequestBody Post post) {
        return new ResponseEntity<Post>(postService.updatePost(post), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deletePost(@RequestBody Post post) {
        postService.deletePost(post);
        return new ResponseEntity(HttpStatus.OK);
    }
}
