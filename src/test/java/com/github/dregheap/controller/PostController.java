package com.github.dregheap.controller;

import com.github.dregheap.model.Post;
import com.github.dregheap.service.DefaultPostService;
import com.github.dregheap.service.PostService;
import com.mongodb.util.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = {PostController.class})
public class PostController {

//    @Autowired
//    private MockMvc mvc;
//
//
//    @Mock
//    private PostService postService;

    @Test
    public void getAllPostsShouldReturnPostsListAndStatusOK() throws Exception {
//        List<Post> postList = new ArrayList<>(Arrays.asList(new Post(), new Post(), new Post()));
//        PageRequest pageRequest = new PageRequest(0, 2);
//
//        when(postService.findAll()).thenReturn(postList);
//        when(postService.findAll(pageRequest)).thenReturn(new PageImpl<Post>(postList.subList(0, 2)));
//
//        mvc.perform(get("/api/v1/posts"))
//                .andExpect(status().isOk()).andExpect(content().json(JSON.serialize(postList)));
    }

    @Test
    public void createPostShouldReturnStatusCreated() {

    }

    @Test
    public void updatePostShouldReturnStatusNoContent() {
    }

    @Test
    public void detelePostShouldReturnStatusOK() {

    }
}
