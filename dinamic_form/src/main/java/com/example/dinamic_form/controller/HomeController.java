package com.example.dinamic_form.controller;

// Importar dependencias: 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @GetMapping("/")
    String home() {
        return "index";
    }

}
