package com.mona.mona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/login")
    public String korisnik(Principal principal){
        System.out.println(principal.getName());
        return "radi";
    }
}
