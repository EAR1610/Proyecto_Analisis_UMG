package com.example.demo.controladores;

import com.example.demo.modelos.Reserva;
import com.example.demo.servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin("*")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @PostMapping("/")
    public ResponseEntity<Reserva> guardarReserva(@RequestBody Reserva reserva){
        Reserva reservaGuardada = reservaService.agregarReserva(reserva);
        return ResponseEntity.ok(reservaGuardada);
    }
    @GetMapping
    public List<Reserva> obtenerReservas(){
        return reservaService.buscarReservas();
    }
    @GetMapping("/{reservaId}")
    public Reserva buscarReservaPorId(@PathVariable("reservaId") Long reservaId){
        return reservaService.buscarReserva(reservaId);
    }
    @PutMapping("/")
    public Reserva actualizarReserva(@RequestBody Reserva reserva){
        return reservaService.actualizarReserva(reserva);
    }
    @DeleteMapping("/{reservaId}")
    public void eliminarReservar(@PathVariable("reservaId") Long reservaId){
        reservaService.eliminarReserva(reservaId);
    }
}
