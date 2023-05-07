package com.example.demo.servicios.implementacion;

import com.example.demo.modelos.Reserva;
import com.example.demo.repositorios.ReservaRepository;
import com.example.demo.servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservaServiceImplementacion implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Override
    public Reserva agregarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> buscarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva buscarReserva(Long reservaId) {
        return reservaRepository.findById(reservaId).orElse(null);
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminarReserva(Long reservaId) {
        Reserva reserva = new Reserva();
        reserva.setReservaId(reservaId);
        reservaRepository.delete(reserva);
    }
}
