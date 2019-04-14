package com.mona.mona.controllers;

import com.mona.mona.entity.Kreator;
import com.mona.mona.repository.KreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@RestController
public class UploadController {

    @Autowired
    KreatorRepository kreatorRepository;

    String UPLOAD_IMG = "src/main/resources/";

    @PostMapping("/upload")
    public String uploadFile(
            @RequestParam("file")MultipartFile file,
            @RequestParam(value = "artikl", required = false) String artikl,
            @RequestParam(value = "materijal", required = false) String materijal,
            @RequestParam(value = "kolekcija", required = false) String kolekcija,
            @RequestParam(value = "sifra", required = false) String sifra,
            @RequestParam(value = "datum", required = false) String datum,
            Principal principal) throws IOException {
        System.out.println("STIGAO ZAHTEV");

        Kreator kreator = new Kreator();
        kreator.setArtikl(artikl);
        kreator.setMaterijal(materijal);
        kreator.setKolekcija(kolekcija);
        kreator.setSifra(sifra);
        kreator.setUsername(principal.getName());
        kreator.setSlika(new File("").getCanonicalPath() + "/src/main/resources/" + file.getOriginalFilename());
        kreator.setDatum(datum);

        System.out.println(kreator);
        kreatorRepository.save(kreator);
        System.out.println("USPESNO SACUVAN U BAZI NOVI KORISNIK");

        if (file.isEmpty()){
            return "missing_file";
        }
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_IMG + file.getOriginalFilename());
            Files.write(path, bytes);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
