package com.mona.mona.controllers;

import com.mona.mona.entity.Authorities;
import com.mona.mona.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @GetMapping("/login")
    public String korisnik(Principal principal){
        System.out.println("Korisnik " + principal.getName());
        Authorities a = authoritiesRepository.findByUsername(principal.getName());
        System.out.println(a.getUsername());
        System.out.println(a.getAuthority());
        return a.getAuthority();
    }
}
