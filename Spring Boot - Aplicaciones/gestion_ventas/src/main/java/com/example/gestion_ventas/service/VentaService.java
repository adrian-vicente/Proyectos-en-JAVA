package com.example.gestion_ventas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.gestion_ventas.dto.ProductoDTO;
import com.example.gestion_ventas.dto.VentaDTO;
import com.example.gestion_ventas.model.Producto;
import com.example.gestion_ventas.model.Sucursal;
import com.example.gestion_ventas.model.Venta;
import com.example.gestion_ventas.repository.ProductoRepository;
import com.example.gestion_ventas.repository.SucursalRepository;
import com.example.gestion_ventas.repository.VentaRepository;

@Service
public class VentaService {

    // Inyección de dependencias: 

    private final VentaRepository ventaRepository;
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;
    public VentaService(VentaRepository ventaRepository, SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
        this.ventaRepository = ventaRepository;
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
        
    }

    // Métodos de conversión de entidad a DTO: 

    public VentaDTO toDTO(Venta v) {
        Long sucursal_id = null;
        List<Long> productos_id = new ArrayList<Long>();
        if(v.getSucursal() != null) sucursal_id = v.getSucursal().getId();
        if(!v.getProductos().isEmpty()) for(Producto p : v.getProductos()) productos_id.add(p.getId());
        return new VentaDTO(v.getId(), v.getFecha(), v.getCantidad(), sucursal_id, productos_id);

    } // toDTO

    public Venta toEntity(VentaDTO dto) {
        Sucursal sucursal = new Sucursal();
        List<Producto> productos = new ArrayList<Producto>();
        Optional<Sucursal> opt_sucursal = sucursalRepository.findById(dto.getSucursal_id());

        if(!dto.getList_productos_id().isEmpty()) {
            Optional<Producto> prod_opt = Optional.of(null);
            for(Long prod_id : dto.getList_productos_id()) {
                prod_opt = productoRepository.findById(prod_id);
                if(prod_opt.isPresent()) productos.add(prod_opt.get());
                else continue;

            } // for

        } // if

        // Devolver el nuevo objeto entidad con la información encontrada:

        if(opt_sucursal.isPresent()) return new Venta(dto.getId(), dto.getFecha(), dto.getCantidad(), opt_sucursal.get(), productos);
        else return new Venta(dto.getId(), dto.getFecha(), dto.getCantidad(), sucursal, productos);

    } // toEntity

    // Obtener las ventas a partir del identificador de una sucursal:

    public List<VentaDTO> obtenerVentasSucursal(Long sucursal_id) {
        List<Venta> ventas = ventaRepository.findBySucursalId(sucursal_id);
        List<VentaDTO> ventas_dto = new ArrayList<VentaDTO>();
        if(!ventas.isEmpty()) for(Venta v : ventas) ventas_dto.add(toDTO(v));
        return ventas_dto;
    }

} // class