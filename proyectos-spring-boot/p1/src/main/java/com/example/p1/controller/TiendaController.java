package com.example.p1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import com.example.p1.model.Producto;
import com.example.p1.services.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Class

@Controller
public class TiendaController {

    // Inyección de dependencias: 

    ProductoService productoService;
    public TiendaController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Gestión de rutas:

    @GetMapping("/")
    String welcome(Model model) {
        model.addAttribute("lista", new Producto().getDestacados());
        return "welcome";
    }

    @GetMapping("/productos")
    String productos(Model model) {
        model.addAttribute("lista", Producto.lista_productos);
        return "productos/productos";
    }

    @GetMapping("/product-info")
    String productInfo(Model model) {
        model.addAttribute("producto", Producto.lista_productos.get(0));
        return "productos/product-info";
    }

    @GetMapping("/home")
    String home() {
        return "pages/home";
    }

    @GetMapping("/product/{id}")
    String product_details(@PathVariable int id, Model model) {
        if(productoService.findById(id) != null) {
            model.addAttribute("producto", productoService.findById(id));
            return "productos/product-details";

        } else {
            System.out.println("Se vuelve a la vista welcome.html ya que el producto con el id: " + id + " no está registrado.");
            return "redirect:/";
        }

    }
    
} // class