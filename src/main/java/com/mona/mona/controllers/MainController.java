package com.mona.mona.controllers;

import com.mona.mona.entity.Authorities;
import com.mona.mona.entity.Kreator;
import com.mona.mona.repository.AuthoritiesRepository;
import com.mona.mona.repository.KreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;

@RestController
public class MainController {

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    KreatorRepository kreatorRepository;

    @GetMapping("/login")
    public String korisnik(Principal principal){
        System.out.println("/login");
        
        System.out.println("Korisnik " + principal.getName());
        Authorities a = authoritiesRepository.findByUsername(principal.getName());
        System.out.println(a.getUsername());
        System.out.println(a.getAuthority());
        return a.getAuthority();
    }

    @GetMapping("/kreator-podaci")
    public Kreator podaci(@RequestParam String username){
        System.out.println("/kreator-podaci");
        Kreator k = kreatorRepository.findFirstByUsername(username);
        return k;
    }

    @GetMapping("/test")
    public String test() throws IOException {
        System.out.println(new File("src/main/resources/vizit-kartica.jpg").getAbsolutePath());
        System.out.println(new File("").getAbsolutePath());
        System.out.println(new File("").getPath());
        System.out.println(new File("").getCanonicalPath());

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("resources/vizit-kartica.jpg").getFile());
        System.out.println(file.getPath());

        String filename = "vizit-kartica.jpg";
        InputStream in = getClass().getClassLoader().getResourceAsStream(filename);
        System.out.println(in);
        return "OK";
    }
}
