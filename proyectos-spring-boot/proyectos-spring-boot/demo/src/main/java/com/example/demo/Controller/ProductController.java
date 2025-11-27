// Paquete del controlador

package com.example.demo.Controller;

// Importar dependencias:

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.*;
import com.example.demo.Model.Producto;

// Class

@Controller
@RequestMapping("/producto")
public class ProductController {

    // Mostrar el formulario creando el atributo producto y añadiendolo al modelo: 

    @GetMapping("/form")
    String mostrarFormulario(Model model) {
        model.addAttribute("product_form", new Producto());
        return "producto/formulario";
        
    } // class

    // Método que recogerá el post del formulario

    @PostMapping("/form")
    String enviarFormulario(@ModelAttribute("producto_form") Producto producto, Model model) {
        model.addAttribute("producto", producto);
        return "producto/resultado";

    } // enviarFormulario
        
} // class