package com.example.gestion_ventas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestion_ventas.dto.ProductoDTO;
import com.example.gestion_ventas.dto.SucursalDTO;
import com.example.gestion_ventas.dto.VentaDTO;
import com.example.gestion_ventas.model.Producto;
import com.example.gestion_ventas.model.Sucursal;
import com.example.gestion_ventas.model.Venta;
import com.example.gestion_ventas.repository.ProductoRepository;
import com.example.gestion_ventas.repository.SucursalRepository;
import com.example.gestion_ventas.repository.VentaRepository;

@Service
public class SucursalService {

    // Inyección de dependencias: 

    private final SucursalRepository sucursalRepository;
    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;

    public SucursalService(SucursalRepository sucursalRepository, VentaRepository ventaRepository, ProductoRepository productoRepository) {
        this.sucursalRepository = sucursalRepository;
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;

    }

    // Métodos de conversión de entidad y dto

    public SucursalDTO toDTO(Sucursal sucursal) {
        List<Long> ventas_id = new ArrayList<Long>();
        if(!sucursal.getVentas().isEmpty()) for(Venta v : sucursal.getVentas()) ventas_id.add(v.getId());
        return new SucursalDTO(sucursal.getId(), sucursal.getNombre(), sucursal.getDireccion(), ventas_id);

    } // toDTO

    @Transactional(readOnly = true)
    public Sucursal toEntity(SucursalDTO dto) {
        List<Venta> ventas = new ArrayList<Venta>();
        if(!dto.getList_ventas_id().isEmpty()) {
            Optional<Venta> v_opt = Optional.of(null);
            for(Long v_id : dto.getList_ventas_id()) {
                v_opt = ventaRepository.findById(v_id);
                if(v_opt.isPresent()) ventas.add(v_opt.get());

            } // for

        } // if

        // Devolver el valor convertido a entidad: 

        return new Sucursal(dto.getId(), dto.getNombre(), dto.getDireccion(), ventas);
        
    } // toEntity

    // Método para listar todas las sucursales encontradas en la base de datos: 

    public List<SucursalDTO> obtenerSucursales() {
        List<Sucursal> s_list = sucursalRepository.findAll();
        List<SucursalDTO> dto_list = new ArrayList<SucursalDTO>();
        for(Sucursal s : s_list) dto_list.add(toDTO(s));
        return dto_list;

    } // obtenerSucursales

    // Obtener información de una única sucursal: 

    public SucursalDTO obtenerSucursal(Long id) {
        Optional<Sucursal> suc_opt = sucursalRepository.findById(id);
        if(suc_opt.isPresent()) return toDTO(suc_opt.get());
        else return null;
    }

    // Obtener los productos vendidos por sucursal:

    public List<ProductoDTO> productosVendidoSucursal(Long sucursal_id) {
        List<Venta> ventas = ventaRepository.findBySucursalId(sucursal_id);
        List<Producto> productos_venta = new ArrayList<Producto>();
        List<ProductoDTO> productos_venta_dto = new ArrayList<ProductoDTO>();
        if(!ventas.isEmpty()) for(Venta v : ventas) if(!v.getProductos().isEmpty()) for(Producto prod : v.getProductos()) productos_venta.add(prod);
        for(Producto prod : productos_venta) {
            List<Long> ventas_id = new ArrayList<Long>();
            if(!prod.getVentas().isEmpty()) for(Venta v : prod.getVentas()) ventas_id.add(v.getId());
            productos_venta_dto.add(new ProductoDTO(prod.getId(), prod.getNombre(), prod.getCategoria(), prod.getPrecio(), ventas_id));

        } // for

        // Devolver la lista de productos encontrados que se ha vendido para una misma sucursal: 

        return productos_venta_dto;
        
    }

}