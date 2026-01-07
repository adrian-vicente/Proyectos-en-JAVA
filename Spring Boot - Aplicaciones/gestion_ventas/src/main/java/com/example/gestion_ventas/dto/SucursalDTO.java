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
public class SucursalDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private List<Long> list_ventas_id;

    // Declaración de métodos personalizados

    @Override
    public String toString() {
        return "Identificador: " + this.getId() + ", nombre: " + this.getNombre() + ", dirección: " + this.getDireccion();
    }

}