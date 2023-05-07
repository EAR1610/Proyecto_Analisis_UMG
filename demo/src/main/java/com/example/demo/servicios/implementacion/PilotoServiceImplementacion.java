package com.example.demo.servicios.implementacion;

import com.example.demo.modelos.Piloto;
import com.example.demo.repositorios.PilotoRepository;
import com.example.demo.servicios.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoServiceImplementacion implements PilotoService {
    @Autowired
    private PilotoRepository pilotoRepository;

    @Override
    public Piloto agregarPiloto(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    @Override
    public List<Piloto> buscarPilotos() {
        return pilotoRepository.findAll();
    }

    @Override
    public Piloto buscarPiloto(Long pilotoId) {
        return pilotoRepository.findById(pilotoId).orElse(null);
    }

    @Override
    public Piloto actualizarPiloto(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    @Override
    public void eliminarPiloto(Long pilotoId) {
        Piloto piloto = new Piloto();
        piloto.setPilotoId(pilotoId);
        pilotoRepository.delete(piloto);
    }
}
