package com.example.demo.servicios;

import com.example.demo.modelos.Piloto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PilotoService {
    Piloto agregarOActualizarPiloto (Piloto piloto);
    List<Piloto> buscarPilotos();
    Piloto buscarPiloto(Long pilotoId);
    void eliminarPiloto(Long pilotoId);
}
