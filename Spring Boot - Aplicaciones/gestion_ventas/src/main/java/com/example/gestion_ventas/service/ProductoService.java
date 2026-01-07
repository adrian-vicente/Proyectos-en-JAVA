package com.example.gestion_ventas.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestion_ventas.dto.ProductoDTO;
import com.example.gestion_ventas.model.Producto;
import com.example.gestion_ventas.repository.ProductoRepository;
import com.example.gestion_ventas.model.Venta;
import com.example.gestion_ventas.repository.VentaRepository;

@Service
public class ProductoService {

    // Inyección de dependencias

    private final ProductoRepository productoRepository;
    private final VentaRepository ventaRepository;
    public ProductoService(ProductoRepository productoRepository, VentaRepository ventaRepository) {
        this.productoRepository = productoRepository;
        this.ventaRepository = ventaRepository;
    }

    // Métodos de conversión de entidad a DTO: 

    private ProductoDTO toDTO(Producto producto) {
        List<Long> ventas_id = new ArrayList<Long>();
        if(!producto.getVentas().isEmpty()) {
            for(Venta v : producto.getVentas()) ventas_id.add(v.getId());

        } // if
        
        // Devolver el nuevo objeto de tipo producto DTO: 

        return new ProductoDTO(producto.getId(), producto.getNombre(), producto.getCategoria(), producto.getPrecio(), ventas_id);

    } // toDTO

    @Transactional(readOnly = true)
    private Producto toEntity(ProductoDTO dto) {
        List<Venta> ventas = new ArrayList<Venta>();
        if(!dto.getList_ventas_id().isEmpty()) {
            Optional<Venta> v_opt = Optional.of(null);
            for(Long v_id : dto.getList_ventas_id()) {
                v_opt = ventaRepository.findById(v_id);
                if(v_opt.isPresent()) ventas.add(v_opt.get());

            } // for

        } // if

        // Devolver el valor de entidad con o sin ventas asociadas: 

        return new Producto(dto.getId(), dto.getNombre(), dto.getCategoria(), dto.getPrecio(), ventas);

    } // toEntity

} // class