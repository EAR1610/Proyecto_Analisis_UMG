package com.example.demo.repositorios;

import com.example.demo.modelos.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {

}
