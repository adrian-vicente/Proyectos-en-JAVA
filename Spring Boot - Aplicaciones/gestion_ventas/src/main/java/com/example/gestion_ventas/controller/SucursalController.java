package com.example.gestion_ventas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gestion_ventas.service.ProductoService;
import com.example.gestion_ventas.service.SucursalService;
import com.example.gestion_ventas.service.VentaService;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {

    // Inyección de dependencias: 

    private final SucursalService sucursalService;
    private final VentaService ventaService;
    private final ProductoService productoService;
    
    public SucursalController(SucursalService sucursalService, VentaService ventaService, ProductoService productoService) {
        this.sucursalService = sucursalService;
        this.ventaService = ventaService;
        this.productoService = productoService;
        
    }

    // Ruta para mostrar el listado de todas las sucursales

    @GetMapping
    public String mostrarSucursales(Model model) {
        model.addAttribute("listado", sucursalService.obtenerSucursales());
        return "sucursal/listado";
    }

    // Ruta para mostrar la información de la sucursal pasada cómo parámetro: 
    
    @GetMapping("/{id}")
    public String mostrarInformacionSucursal(@PathVariable Long id, Model model) {
        model.addAttribute("sucursal", sucursalService.obtenerSucursal(id));
        model.addAttribute("listado_ventas", ventaService.obtenerVentasSucursal(id));
        model.addAttribute("listado_productos", sucursalService.productosVendidoSucursal(id));
        return "sucursal/info";

    }

}