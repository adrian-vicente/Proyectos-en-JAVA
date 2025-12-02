package com.example.p1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import com.example.p1.model.FormContact;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.validation.Valid;
import org.springframework.validation.*;

@Controller
@RequestMapping("/contact")
public class FormController {
    
    @GetMapping
    String contact(Model model) {
        model.addAttribute("form", new FormContact());
        return "pages/contact";
    }

    @PostMapping
    String enviar_formulario(@Valid @ModelAttribute("form") FormContact form, BindingResult result, Model model) {
        if(result.hasErrors()) return "pages/contact";
        model.addAttribute("ok", "Formulario enviado correctamente.");
        return "redirect:/";

    } // enviar_formulario

}
