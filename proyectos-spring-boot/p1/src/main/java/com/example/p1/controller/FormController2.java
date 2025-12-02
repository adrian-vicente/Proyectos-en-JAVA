package com.example.p1.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.p1.model.FormContact;
import com.example.p1.model.FormEntry;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/contact2")
public class FormController2 {

    @GetMapping
    String mostrar(Model model) {
        
        // Obtener los campos del formulario y añadirlos a la lista:
        
        ArrayList<FormEntry> campos = new ArrayList<>();
        
        FormEntry nombre = new FormEntry();
        nombre.setName("nombre");
        nombre.setType("text");
        nombre.setPlaceholder("Introduce tu nombre aquí:");
        campos.add(nombre);

        FormEntry email = new FormEntry();
        email.setName("email");
        email.setType("email");
        email.setPlaceholder("Introduce a continuación tu correo.");
        campos.add(email);

        FormEntry mensaje = new FormEntry();
        mensaje.setName("mensaje");
        mensaje.setType("text");
        mensaje.setPlaceholder("Introduce a continuación tu mensaje");
        campos.add(mensaje);

        // Añadir la lista de campos al modelo

        model.addAttribute("form", new FormContact());
        model.addAttribute("formulario", campos);

        // Devolver la vista del formulario:

        return "pages/contact2";
    }

    @PostMapping
    String rFormulario(@Valid @ModelAttribute("form") FormContact form, BindingResult result, Model model) {
        if(result.hasErrors()) return "pages/contact";
        model.addAttribute("ok", "El formulario ha sido enviado correctamente.");
        return "redirect:/";

    };
    
}