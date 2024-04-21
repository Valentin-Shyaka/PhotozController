package com.example.studyproject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component/
@Service
public class PhotoService {
    
    private Map<String,Photo> db= new HashMap<>(){{
        put("1", new Photo("1","hello.jpg"));
    }};

    public Collection<Photo> get(){
        return null;
    }
}
