package com.example.security_form.controller;

import com.example.security_form.security.PersonDetails;
import com.example.security_form.service.PersonDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final PersonDetailService personDetailService;

    public PersonController(PersonDetailService personDetailService) {
        this.personDetailService = personDetailService;
    }

    // получаем доступ ко всем полям пользователя, к которым можно обращаться по методам из обертки
    @GetMapping ("/show")
    public String showAllFiles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return "hello " + personDetails.getUsername();
    }

//    @PutMapping("/login")
//    public UserDetails getAuthorities(@Valid @RequestParam("user") String user, @RequestParam("password") String password) {
//        return personDetailService.getAuthorities(user, password);
//    }
}

