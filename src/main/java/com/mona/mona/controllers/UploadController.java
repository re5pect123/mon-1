package com.mona.mona.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {


    String UPLOAD_IMG = "C:\\out\\";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file, @RequestParam("ime") String ime){

        System.out.println("IME JE " + ime);
        if (file.isEmpty()){
            return "PRAZAN FILE";
        }
        System.out.println("STIGAO ZAHTEV");
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_IMG + System.currentTimeMillis() + file.getOriginalFilename());
            Files.write(path, bytes);

            return "SVE OK";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
