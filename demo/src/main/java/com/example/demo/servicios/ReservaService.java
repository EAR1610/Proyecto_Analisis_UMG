package com.example.demo.servicios;

import com.example.demo.modelos.Reserva;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservaService {
    Reserva agregarOActualizarReserva(Reserva reserva);
    List<Reserva> buscarReservas();
    Reserva buscarReserva(Long reservaId);
    void eliminarReserva(Long reservaId);
}
