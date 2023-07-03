package com.controllers;

import com.services.AgreementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
@RequestMapping("/agreements")
public class AgreementController {
    @Resource
    private AgreementService service;

    @GetMapping("/myAgreements")
    public String myAgreements(Model model, Principal pr){
        model.addAttribute("agreements", service.findAllBySellerEmail(pr.getName()));
        return "my-agreements";
    }

    @GetMapping("/deleteAgr/{id}")
    public String deleteAgr(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/agreements/myAgreements";
    }
}
