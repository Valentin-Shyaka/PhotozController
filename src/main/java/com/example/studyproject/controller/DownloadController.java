package com.example.studyproject.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.studyproject.model.Photo;
import com.example.studyproject.services.PhotoService;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DownloadController {

    private final PhotoService photoService;

    public DownloadController(PhotoService photoService){
     this.photoService = photoService;
    }
 


    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){

        Photo photo = photoService.get(id);

        if(photo == null ) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data= photo.getData();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(build);



        return new ResponseEntity<>(data,headers,HttpStatus.OK);
    }
    
}
