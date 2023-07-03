package com.controllers;

import com.dtos.full_info.UserFullInfoDto;
import com.dtos.post.UserPostDto;
import com.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @GetMapping("/all")
    public String users(Model model){
        model.addAttribute("users", service.findAll());
        return "users";
    }

    @PutMapping("/form-update")
    public String update(Model model){
        model.addAttribute("user", new UserFullInfoDto());
        return "user-update";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        System.out.println(id);
        service.deleteById(Integer.parseInt(id));
        return "redirect:/users/all";
    }

    @GetMapping("/details")
    public String userDetails(Model model, Principal pr){
        model.addAttribute("user", service.findByEmail(pr.getName()));
        return "user-details";
    }
}
