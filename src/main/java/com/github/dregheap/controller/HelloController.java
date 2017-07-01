package com.github.dregheap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getHelloMessage() {
        return new ResponseEntity<>("Hello world!", HttpStatus.OK);
    }
}
