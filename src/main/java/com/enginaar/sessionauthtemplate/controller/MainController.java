package com.enginaar.sessionauthtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
     
    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
