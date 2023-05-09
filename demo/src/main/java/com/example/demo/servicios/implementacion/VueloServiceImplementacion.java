package com.example.demo.servicios.implementacion;

import com.example.demo.modelos.Vuelo;
import com.example.demo.repositorios.VueloRepository;
import com.example.demo.servicios.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImplementacion implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    public Vuelo agregarOActualizarVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Override
    public List<Vuelo> buscarVuelos() {
        return vueloRepository.findAll();
    }
    @Override
    public Vuelo buscarVuelo(Long vueloId) {
        return vueloRepository.findById(vueloId).orElse(null);
    }
    @Override
    public void eliminarVuelo(Long vueloId) {
        Vuelo vuelo = new Vuelo();
        vuelo.setVueloId(vueloId);
        vueloRepository.delete(vuelo);
    }
}
