package com.mona.mona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @GetMapping("/login")
    public String korisnik(Principal principal){

        System.out.println("korisnik " + principal.getName());

        return "RADI";
    }
}
