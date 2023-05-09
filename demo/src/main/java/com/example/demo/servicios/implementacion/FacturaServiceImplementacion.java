package com.example.demo.servicios.implementacion;

import com.example.demo.modelos.Factura;
import com.example.demo.repositorios.FacturaRepository;
import com.example.demo.servicios.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacturaServiceImplementacion implements FacturaService {
    @Autowired FacturaRepository facturaRepository;

    @Override
    public Factura agregaroActualizarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }
    @Override
    public List<Factura> buscarFacturas() {
        return facturaRepository.findAll();
    }
    @Override
    public Factura buscarFactura(Long facturaId) {
        return facturaRepository.findById(facturaId).orElse(null);
    }
    @Override
    public void eliminarFactura(Long facturaId) {
        Factura factura = new Factura();
        factura.setFacturaId(facturaId);
        facturaRepository.delete(factura);
    }
}
