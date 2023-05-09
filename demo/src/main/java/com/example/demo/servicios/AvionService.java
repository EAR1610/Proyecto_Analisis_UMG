package com.example.demo.servicios;

import com.example.demo.modelos.Avion;

import java.util.List;

public interface AvionService {
    Avion agregarOActualizarAvion (Avion avion);
    Avion obtenerAvion (Long avionId);
    List<Avion> obtenerAviones();
    void eliminarAvion(Long avionId);
}
