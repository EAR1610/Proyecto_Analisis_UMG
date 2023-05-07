package com.example.demo.controladores;

import com.example.demo.modelos.Factura;
import com.example.demo.servicios.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@CrossOrigin("*")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;
    @PostMapping("/")
    public ResponseEntity<Factura> guardarFactura(@RequestBody Factura factura){
        Factura facturaGuardada = facturaService.agregarFactura(factura);
        return ResponseEntity.ok(facturaGuardada);
    }
    @GetMapping
    public List<Factura> obtenerFacturas(){
        return facturaService.buscarFacturas();
    }
    @GetMapping("/{facturaId}")
    public Factura buscarFacturaPorId(@PathVariable("facturaId") Long facturaId){
        return facturaService.buscarFactura(facturaId);
    }
    @PutMapping("/")
    public Factura actualizarFactura(@RequestBody Factura factura){
        return facturaService.actualizarFactura(factura);
    }
    @DeleteMapping("/{facturaId}")
    public void eliminarFactura(@PathVariable("facturaId") Long facturaId){
        facturaService.eliminarFactura(facturaId);
    }
}
