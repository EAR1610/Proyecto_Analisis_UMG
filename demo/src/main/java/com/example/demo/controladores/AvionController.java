package com.example.demo.controladores;

import com.example.demo.modelos.Avion;
import com.example.demo.modelos.Usuario;
import com.example.demo.servicios.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aviones")
@CrossOrigin("*")
public class AvionController {
    @Autowired
    private AvionService avionService;

    @PostMapping("/")
    public ResponseEntity<Avion> guardarAvion(@RequestBody Avion avion){
        Avion avionGuardado = avionService.agregarAvion(avion);
        return ResponseEntity.ok(avionGuardado);
    }
    @GetMapping("/{avionId}")
    public Avion buscarAvionPorId(@PathVariable("avionId") Long avionId){
        return avionService.obtenerAvion(avionId);
    }
    @PutMapping("/")
    public Avion actualizarAvion(@RequestBody Avion avion){
        return avionService.actualizarAvion(avion);
    }

    @DeleteMapping("/{avionId}")
    public void eliminarAvion(@PathVariable("avionId") Long avionId){
        avionService.eliminarAvion(avionId);
    }
}
