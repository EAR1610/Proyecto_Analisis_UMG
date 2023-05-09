package com.example.demo.servicios;

import com.example.demo.modelos.Factura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturaService {
    Factura agregaroActualizarFactura(Factura factura);
    List<Factura> buscarFacturas();
    Factura buscarFactura(Long facturaId);
    void eliminarFactura(Long facturaId);
}
