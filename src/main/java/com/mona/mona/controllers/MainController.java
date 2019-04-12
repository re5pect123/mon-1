package com.mona.mona.controllers;

import com.mona.mona.entity.Authorities;
import com.mona.mona.entity.Kreator;
import com.mona.mona.repository.AuthoritiesRepository;
import com.mona.mona.repository.KreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class MainController {

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    KreatorRepository kreatorRepository;

    @GetMapping("/login")
    public String korisnik(Principal principal){
        System.out.println("Korisnik " + principal.getName());
        Authorities a = authoritiesRepository.findByUsername(principal.getName());
        System.out.println(a.getUsername());
        System.out.println(a.getAuthority());
        return a.getAuthority();
    }

    @GetMapping("/kreator-podaci")
    public Kreator podaci(@RequestParam String username){
        Kreator k = kreatorRepository.findFirstByUsername(username);
        return k;
    }
}
