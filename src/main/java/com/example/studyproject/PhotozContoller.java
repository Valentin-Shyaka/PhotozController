package com.example.studyproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotozContoller {

    @GetMapping("/ ")
    public String hello(){
        return "hello world";
    }
}
