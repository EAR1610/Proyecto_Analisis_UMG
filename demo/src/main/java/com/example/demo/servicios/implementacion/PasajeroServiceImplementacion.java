package com.example.demo.servicios.implementacion;

import com.example.demo.modelos.Pasajero;
import com.example.demo.repositorios.PasajeroRepository;
import com.example.demo.servicios.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroServiceImplementacion implements PasajeroService {
    @Autowired
    private PasajeroRepository pasajeroRepository;
    @Override
    public Pasajero agregarOActualizarPasajero(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }
    @Override
    public List<Pasajero> buscarPasajeros() {
        return pasajeroRepository.findAll();
    }
    @Override
    public Pasajero buscarPasajero(Long pasajeroId) {
        return pasajeroRepository.findById(pasajeroId).orElse(null);
    }

    @Override
    public void eliminarPasajero(Long pasajeroId) {
        Pasajero pasajero = new Pasajero();
        pasajero.setPasajeroId(pasajeroId);
        pasajeroRepository.delete(pasajero);
    }
}
