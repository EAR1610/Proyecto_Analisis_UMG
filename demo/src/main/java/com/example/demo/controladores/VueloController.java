package com.example.demo.controladores;

import com.example.demo.modelos.Vuelo;
import com.example.demo.servicios.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
@CrossOrigin("*")
public class VueloController {
    //Inyectar el servicio correspondiente
    @Autowired
    private VueloService vueloService;
    @PostMapping("/")
    public ResponseEntity<Vuelo> guardarVuelo(@RequestBody Vuelo vuelo){
        Vuelo vueloGuardado = vueloService.agregarVuelo(vuelo);
        return ResponseEntity.ok(vueloGuardado);
    }
    @GetMapping
    public List<Vuelo> obtenerVuelos(){
        return vueloService.buscarVuelos();
    }
    @GetMapping("/{vueloId}")
    public Vuelo buscarVueloPorId(@PathVariable("vueloId") Long vueloId){
        return vueloService.buscarVuelo(vueloId);
    }

    @PutMapping("/")
    public Vuelo actualizarVuelo(@RequestBody Vuelo vuelo){
        return vueloService.actualizarVuelo(vuelo);
    }

    @DeleteMapping("/{vueloId}")
    public void eliminarvuelo(@PathVariable("vueloId") Long vueloId){
        vueloService.eliminarVuelo(vueloId);
    }
}
