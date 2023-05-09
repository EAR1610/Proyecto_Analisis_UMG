package com.example.demo.controladores;

import com.example.demo.modelos.Pasajero;
import com.example.demo.servicios.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
@CrossOrigin("*")
public class PasajeroController {
    @Autowired
    private PasajeroService pasajeroService;

    @PostMapping("/")
    public ResponseEntity<Pasajero> guardarPasajero(@RequestBody Pasajero pasajero){
        Pasajero pasajeroGuardado = pasajeroService.agregarOActualizarPasajero(pasajero);
        return ResponseEntity.ok(pasajeroGuardado);
    }

    @GetMapping
    public List<Pasajero> obtenerPilotos(){
        return pasajeroService.buscarPasajeros();
    }

    @GetMapping("/{pasajeroId}")
    public Pasajero buscarPasajeroPorId(@PathVariable("pasajeroId") Long pasajeroId){
        return pasajeroService.buscarPasajero(pasajeroId);
    }

    @PutMapping("/")
    public Pasajero actualizarPasajero(@RequestBody Pasajero pasajero){
        return pasajeroService.agregarOActualizarPasajero(pasajero);
    }

    @DeleteMapping("/{pasajeroId}")
    public void eliminarPasajero(@PathVariable("pasajeroId") Long pasajeroId){
        pasajeroService.eliminarPasajero(pasajeroId);
    }
}
