package com.example.gestion_ventas.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaDTO {
    private Long id;
    private LocalDateTime fecha;
    private Integer cantidad;
    private Long sucursal_id;
    private List<Long> list_productos_id;

    // Declaración de métodos personalizados

    @Override
    public String toString() {
        return "Identificador: " + this.getId() + ", fecha: " + this.getFecha() + ", cantidad: " + this.getCantidad();
    }

}