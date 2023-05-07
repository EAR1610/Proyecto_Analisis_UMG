package com.example.demo.repositorios;

import com.example.demo.modelos.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Long> {
}
