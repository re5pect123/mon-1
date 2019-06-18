package com.mona.mona.controllers;

import com.mona.mona.entity.Authorities;
import com.mona.mona.entity.Users;
import com.mona.mona.repository.AuthoritiesRepository;
import com.mona.mona.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @GetMapping("/test1")
    public String test(){
        System.out.println("Pogodjen test - aplikacija podignuta i radi \n");
        return "USPESAN TEST";
    }

    @GetMapping("/kreiranje-korisnika")
    public String kreiranjeKorisnika(){
        System.out.println("Received request: /kreiranje korisnika");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Users dizajner = new Users();
        dizajner.setUsername("dizajner");
        dizajner.setPassword(bCryptPasswordEncoder.encode("123"));
        dizajner.setEnabled(true);
        usersRepository.save(dizajner);
        System.out.println("Kreiran korisnik: " + dizajner.toString());
        Authorities rolaDizajner = new Authorities();
        rolaDizajner.setUsername("dizajner");
        rolaDizajner.setAuthority("ROLE_DIZAJNER");
        authoritiesRepository.save(rolaDizajner);
        System.out.println("Kreirana rola: ROLE_DIZAJNER za: " + dizajner.getUsername() + "\n");

        return "Uspesno kreirano!";
    }
}
