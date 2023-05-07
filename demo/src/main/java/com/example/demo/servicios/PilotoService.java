package com.example.demo.servicios;

import com.example.demo.modelos.Piloto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PilotoService {
    Piloto agregarPiloto (Piloto piloto);
    List<Piloto> buscarPilotos();
    Piloto buscarPiloto(Long pilotoId);
    Piloto actualizarPiloto(Piloto piloto);
    void eliminarPiloto(Long pilotoId);
}
