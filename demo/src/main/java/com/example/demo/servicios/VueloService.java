package com.example.demo.servicios;

import com.example.demo.modelos.Vuelo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VueloService {
    Vuelo agregarVuelo(Vuelo vuelo);
    List<Vuelo> buscarVuelos();
    Vuelo buscarVuelo(Long vueloId);
    Vuelo actualizarVuelo(Vuelo vuelo);
    void eliminarVuelo(Long vueloId);
}
