package com.github.dregheap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dregheap.model.Post;
import com.github.dregheap.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = {PostController.class})
public class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    private ObjectMapper objectWriter;

    @Before
    public void setUp() {
        objectWriter = new ObjectMapper();
    }

    @Test
    public void getAllPostsShouldReturnPostsListAndStatusOK() throws Exception {
        List<Post> postList = new ArrayList<>(Arrays.asList(new Post(), new Post(), new Post()));
        PageRequest pageRequest = new PageRequest(0, 2);
        PageImpl<Post> pageList = new PageImpl<>(postList.subList(0, 2));

        when(postService.findAll()).thenReturn(postList);
        when(postService.findAll(pageRequest)).thenReturn(pageList);

        mvc.perform(get("/api/v1/posts"))
                .andExpect(status().isOk()).andExpect(content().json(objectWriter.writeValueAsString(postList)));
    }

    @Test
    public void createPostShouldReturnStatusCreated() throws Exception {
        Post creatingPost = new Post();
        creatingPost.setId("1");
        creatingPost.setPostMessage("testMessage");
        creatingPost.setTopicId("1");
        creatingPost.setUserId("1");

        when(postService.create(creatingPost)).thenReturn(creatingPost);

        mvc.perform(post("/api/v1/posts").contentType("application/json").content(objectWriter.writeValueAsString(creatingPost)))
                .andExpect(status().isCreated()).andExpect(content().json(objectWriter.writeValueAsString(creatingPost)));

    }

    @Test
    public void updatePostShouldReturnStatusNoContent() throws Exception {
        Post creatingPost = new Post();
        creatingPost.setId("1");
        creatingPost.setPostMessage("testMessage");
        creatingPost.setTopicId("1");
        creatingPost.setUserId("1");

        when(postService.update(creatingPost)).thenReturn(creatingPost);

        mvc.perform(put("/api/v1/posts").contentType("application/json").content(objectWriter.writeValueAsString(creatingPost)))
                .andExpect(status().isNoContent()).andExpect(content().json(objectWriter.writeValueAsString(creatingPost)));

    }

    @Test
    public void detelePostShouldReturnStatusOK() throws Exception {
        Post post = new Post();

        doNothing().when(postService).delete(post);
        doNothing().when(postService).deleteById("1");

        mvc.perform(delete("/api/v1/posts").contentType("application/json").content(objectWriter.writeValueAsString(post)))
                .andExpect(status().isOk());
        mvc.perform(delete("/api/v1/posts/1"))
                .andExpect(status().isOk());


    }
}
