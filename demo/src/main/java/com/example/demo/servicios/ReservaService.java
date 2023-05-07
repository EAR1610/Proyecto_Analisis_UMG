package com.example.demo.servicios;

import com.example.demo.modelos.Reserva;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservaService {
    Reserva agregarReserva(Reserva reserva);
    List<Reserva> buscarReservas();
    Reserva buscarReserva(Long reservaId);
    Reserva actualizarReserva(Reserva reserva);
    void eliminarReserva(Long reservaId);
}
