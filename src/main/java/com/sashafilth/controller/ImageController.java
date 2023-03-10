package com.sashafilth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class ImageController {

    private static final Logger log = LoggerFactory.getLogger(ImageController.class);


    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getImage() throws IOException {
        System.out.println("Get image from controller.");
        InputStream is = getClass().getResourceAsStream("/grumpy.jpg");
        ByteArrayResource res = new ByteArrayResource(is.readAllBytes());
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(res.contentLength())
                .body(res);
    }
}
