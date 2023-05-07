package com.example.demo.servicios.implementacion;

import com.example.demo.modelos.Avion;
import com.example.demo.repositorios.AvionRepository;
import com.example.demo.servicios.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionServiceImplementacion implements AvionService {

    @Autowired
    private AvionRepository avionRepository;

    @Override
    public Avion agregarAvion(Avion avion) {
        return avionRepository.save(avion);
    }

    @Override
    public Avion buscarAvion(Long avionId) {
        return avionRepository.findById(avionId).orElse(null);
    }

    @Override
    public Avion actualizarAvion(Avion avion) {
        return avionRepository.save(avion);
    }

    @Override
    public Avion obtenerAvion(Long avionId) {
        return avionRepository.findById(avionId).orElse(null);
    }

    @Override
    public void eliminarAvion(Long avionId) {
        Avion avion = new Avion();
        avion.setAvionId(avionId);
        avionRepository.delete(avion);
    }
}
