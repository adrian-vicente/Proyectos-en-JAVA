package com.example.gestion_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestion_ventas.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
