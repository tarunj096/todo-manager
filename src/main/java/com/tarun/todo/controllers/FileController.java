package com.tarun.todo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger log = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/single")
    public String uploadFile(@RequestParam("image")MultipartFile file){
        log.info("Name :{}",file.getName());
        log.info("Content type: {}",file.getContentType());
        log.info("Original file name : {}",file.getOriginalFilename());
        log.info("File Size:{}",file.getSize());

        return "File";
    }
}
