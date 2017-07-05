package com.github.dregheap.service;

import com.github.dregheap.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Page<Post> findAll(Pageable pageable);

    Post findById(String id);

    Post create(Post post);

    Post update(Post post);

    void delete(Post post);

    void deleteById(String id);
}
