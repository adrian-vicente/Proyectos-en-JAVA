package com.example.gestion_ventas.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String categoria;
    private Double precio;
    private List<Long> list_ventas_id;

    // Métodos personalizados: 

    @Override
    public String toString() {
        return "Identificador: " + this.getId() + ", nombre: " + this.getNombre() + ", categoría: " + this.getCategoria() + ", precio: " + this.getPrecio() + "€";
    }

}
