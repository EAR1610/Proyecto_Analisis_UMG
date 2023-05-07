package com.example.demo.servicios;

import com.example.demo.modelos.Avion;

public interface AvionService {
    Avion agregarAvion (Avion avion);
    Avion buscarAvion (Long id);
    Avion actualizarAvion (Avion avion);
    Avion obtenerAvion (Long avionId);
    void eliminarAvion(Long avionId);
}
