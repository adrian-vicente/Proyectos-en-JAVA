package com.example.dinamic_form.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dinamic_form.model.*;
import com.example.dinamic_form.services.ContactFormService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/contacto")
public class FormController {

    // Inyección de dependencias: 

    ContactFormService cfs;
    public FormController(ContactFormService cfs) {
        this.cfs = cfs;
    }

    // Gestión de rutas:

    @GetMapping
    public String contacto(Model model) {
        List<FormEntry> lista = cfs.lista();
        model.addAttribute("fc", new FormContact());
        model.addAttribute("lista", lista);
        return "pages/contact";
    }

    @PostMapping
    public String contacto_ok(@Valid @ModelAttribute("fc") FormContact fc, BindingResult result) {
        if(result.hasErrors()) {
            return "pages/contact";

        } else return "pages/contact-ok";

    } // contacto_ok

}
