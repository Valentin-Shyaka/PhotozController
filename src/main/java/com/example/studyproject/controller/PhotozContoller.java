package com.example.studyproject.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.studyproject.model.Photo;
import com.example.studyproject.services.PhotoService;



@RestController
public class PhotozContoller {


   private final PhotoService photoService;

   public PhotozContoller(PhotoService photoService){
    this.photoService = photoService;
   }

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return photoService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = photoService.get(id);

        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = photoService.remove(id);

        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException{
      
      return photoService.save(file.getOriginalFilename(), file.getBytes(),file.getContentType());
        
    }
    
}
