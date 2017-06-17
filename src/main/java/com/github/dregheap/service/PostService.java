package com.github.dregheap.service;

import com.github.dregheap.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Page<Post> findAll(Pageable pageable);

//    Post findOne(String id);

    Post createPost(Post post);

    Post updatePost(Post post);

    void deletePost(Post post);
}
