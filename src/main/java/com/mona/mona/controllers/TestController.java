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
        return "USPESAN TEST";
    }

    @GetMapping("/kreiranje-korisnika")
    public String kreiranjeKorisnika(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Users dizajner = new Users();
        dizajner.setUsername("dizajner");
        dizajner.setPassword(bCryptPasswordEncoder.encode("123"));
        dizajner.setEnabled(true);
        usersRepository.save(dizajner);
        Authorities rolaDizajner = new Authorities();
        rolaDizajner.setUsername("dizajner");
        rolaDizajner.setAuthority("ROLE_DIZAJNER");
        authoritiesRepository.save(rolaDizajner);

        return "Uspesno kreirano!";
    }
}
