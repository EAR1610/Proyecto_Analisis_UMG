package com.example.demo.servicios.implementacion;

import com.example.demo.modelos.Avion;
import com.example.demo.repositorios.AvionRepository;
import com.example.demo.servicios.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionServiceImplementacion implements AvionService {

    @Autowired
    private AvionRepository avionRepository;
    @Override
    public Avion agregarOActualizarAvion(Avion avion) {
        return avionRepository.save(avion);
    }
    @Override
    public Avion obtenerAvion(Long avionId) {
        return avionRepository.findById(avionId).orElse(null);
    }
    @Override
    public List<Avion> obtenerAviones() {
        return avionRepository.findAll();
    }
    @Override
    public void eliminarAvion(Long avionId) {
        Avion avion = avionRepository.findById(avionId).orElse(null);
        avionRepository.delete(avion);
    }
}
