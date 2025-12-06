package com.example.dinamic_form.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dinamic_form.model.FormEntry;

@Service
public class ContactFormService {
    public List<FormEntry> lista() {
        List<FormEntry> lista_form = new ArrayList<FormEntry>();
        lista_form.add(new FormEntry("nombre", "text"));
        lista_form.add(new FormEntry("email", "email"));
        lista_form.add(new FormEntry("mensaje", "text"));
        return lista_form;
    }
    
}