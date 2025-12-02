package com.example.p1.services;

import org.springframework.stereotype.Service;
import com.example.p1.model.Producto;

// Class

@Service
public class ProductoService {
    
    // Método para obtener producto mediante ID

    public Producto findById(int id) {
        for(Producto p : Producto.lista_productos) {
            if(p.getId() == id) return p;
            else continue;
        }

        return null;

    } // findById()

} // class