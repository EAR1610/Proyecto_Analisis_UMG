package com.example.demo.servicios;

import com.example.demo.modelos.Pasajero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PasajeroService {
    Pasajero agregarPasajero (Pasajero pasajero);
    List<Pasajero> buscarPasajeros();
    Pasajero buscarPasajero(Long pasajeroId);
    Pasajero actualizarPasajero(Pasajero pasajero);
    void eliminarPasajero(Long pasajeroId);
}
