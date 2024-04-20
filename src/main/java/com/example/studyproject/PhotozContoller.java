package com.example.studyproject;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PhotozContoller {

    private List<Photo> db= List.of(new Photo("1","hello.jpg"))

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/photoz")
    public List<Photo> get() {
        return db;
    }
    
}
