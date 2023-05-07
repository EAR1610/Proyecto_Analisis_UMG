package com.example.demo.controladores;

import com.example.demo.modelos.Piloto;
import com.example.demo.servicios.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotos")
@CrossOrigin("*")
public class PilotoController {
    @Autowired
    private PilotoService pilotoService;
    @PostMapping("/")
    public ResponseEntity<Piloto> guardarPiloto(@RequestBody Piloto piloto){
        Piloto pilotoGuardado = pilotoService.agregarPiloto(piloto);
        return ResponseEntity.ok(pilotoGuardado);
    }
    @GetMapping
    public List<Piloto> obtenerPilotos(){
        return pilotoService.buscarPilotos();
    }
    @GetMapping("/{pilotoId}")
    public Piloto buscarPilotoPorId(@PathVariable("pilotoId")Long pilotoId){
        return pilotoService.buscarPiloto(pilotoId);
    }
    @PutMapping("/")
    public Piloto actualizarPiloto(@RequestBody Piloto piloto){
        return pilotoService.actualizarPiloto(piloto);
    }
    @DeleteMapping("/{pilotoId}")
    public void eliminarPiloto(@PathVariable("pilotoId") Long pilotoId){
        pilotoService.eliminarPiloto(pilotoId);
    }
}
