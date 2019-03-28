package com.mona.mona.controllers;

import com.mona.mona.entity.Korisnik;
import com.mona.mona.entity.KorisnikResponse;
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
    public KorisnikResponse korisnik(Principal principal){
        System.out.println("USERNAME " + principal.getName());
        System.out.println("ALL "  + principal.toString());

        System.out.println("pogodjen korisnik");
        KorisnikResponse kr = new KorisnikResponse();
        kr.setAktivan(true);
        kr.setRola("DIZAJNER");
        System.out.println(kr);
        return kr;
    }
}
