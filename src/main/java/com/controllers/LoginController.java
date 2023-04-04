package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping({"/", "home"})
    public String home(){
        return "home";
    }

    @GetMapping("/login-form")
    public String login(){
        return "login";
    }
}
