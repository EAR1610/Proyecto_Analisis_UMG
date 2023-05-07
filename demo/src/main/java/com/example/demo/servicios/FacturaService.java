package com.example.demo.servicios;

import com.example.demo.modelos.Factura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturaService {
    Factura agregarFactura(Factura factura);
    List<Factura> buscarFacturas();
    Factura buscarFactura(Long facturaId);
    Factura actualizarFactura(Factura factura);
    void eliminarFactura(Long facturaId);
}
