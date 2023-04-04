package com.controllers;

import com.dtos.post.UserPostDto;
import com.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/form-create")
    public String formCreate(Model model){
        model.addAttribute("user", new UserPostDto());
        return "user-create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("user")UserPostDto user, BindingResult result){
        if (result.hasErrors()) {
            return "user-create";
        }
        service.save(user);
        return "redirect:/home";
    }
}
