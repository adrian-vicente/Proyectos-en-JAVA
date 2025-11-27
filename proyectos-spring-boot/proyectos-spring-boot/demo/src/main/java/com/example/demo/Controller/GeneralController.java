package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// GeneralController

@Controller
class GeneralController {

    // Ruta de tipo Controller: 
    @GetMapping("/")
    String home() {
        return "index";
    }

    // Ruta de saludo con variable: 
    @GetMapping("/saludar/{nombreCliente}")
    String saludar(@PathVariable String nombreCliente, Model model) {
        model.addAttribute("nombre", nombreCliente);
        System.out.println("Se ha mandado el nombre: " + nombreCliente + ", al fichero: saludar.html");
        return "saludos/saludar";
    }

    // Ruta usando parámetros y valores predeterminados
    
    @GetMapping("/saludoParam")
    String saludarParam(@RequestParam(defaultValue = "Invitado") String nombre, Model model) {
        model.addAttribute("nombre", nombre);
        System.out.println("Se ha mandado el nombre " + nombre + " al fichero: saludarParam.html");
        return "saludos/saludarParam";

    } // saludarParam

} // class