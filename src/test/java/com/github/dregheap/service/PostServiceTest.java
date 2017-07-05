package com.github.dregheap.service;

import com.github.dregheap.model.Post;
import com.github.dregheap.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    private PostService postService;

    @Before
    public void setUp() {
        postService = new DefaultPostService(postRepository);
    }

    @Test
    public void getAllPostsShouldReturnPostsList() {
        List<Post> posts = new ArrayList<>(Arrays.asList(new Post(), new Post(), new Post()));

        when(postRepository.findAll()).thenReturn(posts);

        List<Post> newPosts = postService.findAll();

        assertEquals(3, newPosts.size());

        verify(postRepository).findAll();
    }

    @Test
    public void getAllPostsShouldReturnPagedList() {
        List<Post> list1 = new ArrayList<>(Arrays.asList(new Post(), new Post(), new Post()));
        Page<Post> page1 = new PageImpl<>(list1.subList(0, 2));
        Page<Post> page2 = new PageImpl<>(list1.subList(2, 3));
        Page<Post> page3 = new PageImpl<>(new ArrayList<>());

        PageRequest pgrq1 = new PageRequest(0, 2);
        PageRequest pgrq2 = new PageRequest(1, 2);
        PageRequest pgrq3 = new PageRequest(1, 3);


        when(postRepository.findAll(pgrq1))
                .thenReturn(page1);
        when(postRepository.findAll(pgrq2))
                .thenReturn(page2);
        when(postRepository.findAll(pgrq3)).thenReturn(page3);

        Page<Post> newPage1 = postService.findAll(pgrq1);
        Page<Post> newPage2 = postService.findAll(pgrq2);
        Page<Post> newPage3 = postService.findAll(pgrq3);

        assertEquals(2, newPage1.getContent().size());
        assertEquals(1, newPage2.getContent().size());
        assertEquals(0, newPage3.getContent().size());

        verify(postRepository).findAll(pgrq1);
        verify(postRepository).findAll(pgrq2);
        verify(postRepository).findAll(pgrq3);
    }

    @Test
    public void createPostShouldReturnPostWithId() {
        Post post = new Post();

        when(postRepository.save(post)).thenReturn(post);

        Post newPost = postService.create(post);

        assertThat(newPost).isEqualTo(post);

        verify(postRepository).save(post);
    }

    @Test
    public void updatePostShouldUpdatePost() {
        Post post = new Post();

        when(postRepository.save(post)).thenReturn(post);

        Post newPost = postService.update(post);

        assertThat(newPost).isEqualTo(post);

        verify(postRepository).save(post);
    }

    @Test
    public void deletePostShouldDeletePost() {
        Post post = new Post();
        postService.delete(post);

        verify(postRepository).delete(post);
    }
}