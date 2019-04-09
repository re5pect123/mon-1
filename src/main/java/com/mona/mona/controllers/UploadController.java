package com.mona.mona.controllers;

import com.mona.mona.entity.Kreator;
import com.mona.mona.repository.KreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@RestController
public class UploadController {

    @Autowired
    KreatorRepository kreatorRepository;

    String UPLOAD_IMG = "C:\\out\\";

    @PostMapping("/upload")
    public String uploadFile(
            @RequestParam("file")MultipartFile file,
            @RequestParam("artikl") String artikl,
            @RequestParam("materijal") String materijal,
            @RequestParam("kolekcija") String kolekcija,
            @RequestParam("sifra") String sifra,
            Principal principal){
        System.out.println("STIGAO ZAHTEV");

        Kreator kreator = new Kreator();
        kreator.setArtikl(artikl);
        kreator.setMaterijal(materijal);
        kreator.setKolekcija(kolekcija);
        kreator.setSifra(sifra);
        kreator.setUsername(principal.getName());
        kreator.setSlika(file.getOriginalFilename());

        System.out.println(kreator);
        kreatorRepository.save(kreator);

        if (file.isEmpty()){
            return "missing_file";
        }
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_IMG + System.currentTimeMillis() + file.getOriginalFilename());
            Files.write(path, bytes);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
