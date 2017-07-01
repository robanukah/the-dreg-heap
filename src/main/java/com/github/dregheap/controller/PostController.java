package com.github.dregheap.controller;


import com.github.dregheap.model.Post;
import com.github.dregheap.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/posts")
public class PostController {

    private final PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllPosts() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity getAllPagedPosts(Pageable pageable) {
        return new ResponseEntity<>(postService.findAll(pageable), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getPostById(@PathVariable String id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.create(post), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updatePost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.update(post), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePostById(@PathVariable String id) {
        postService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deletePost(@RequestBody Post post) {
        postService.delete(post);
        return new ResponseEntity(HttpStatus.OK);
    }
}
