package com.example.demo.servicios;

import com.example.demo.modelos.Vuelo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VueloService {
    Vuelo agregarOActualizarVuelo(Vuelo vuelo);
    List<Vuelo> buscarVuelos();
    Vuelo buscarVuelo(Long vueloId);
    void eliminarVuelo(Long vueloId);
}
