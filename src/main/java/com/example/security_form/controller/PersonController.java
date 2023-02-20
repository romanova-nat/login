package com.example.security_form.controller;

import com.example.security_form.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    // получаем доступ ко всем полям пользователя, к которым можно обращаться по методам из обертки
    @GetMapping ("/show")
    public String showAllFiles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return "hello " + personDetails.getUsername();
    }

}
