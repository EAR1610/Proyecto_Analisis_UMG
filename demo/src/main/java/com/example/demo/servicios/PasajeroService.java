package com.example.demo.servicios;

import com.example.demo.modelos.Pasajero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PasajeroService {
    Pasajero agregarOActualizarPasajero (Pasajero pasajero);
    List<Pasajero> buscarPasajeros();
    Pasajero buscarPasajero(Long pasajeroId);
    void eliminarPasajero(Long pasajeroId);
}
