package com.example.gestion_ventas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GeneralController {
    @GetMapping
    public String home() {
        return "redirect:/sucursales";
    }

}
