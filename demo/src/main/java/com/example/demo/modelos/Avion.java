package com.example.demo.modelos;

import javax.persistence.*;

@Entity
@Table(name = "aviones")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avionId;
    private String marca;
    private String modelo;
    private Integer capacidad;
    private String fabricante;
    private String anioFabricacion;
    private boolean activo = true;
}
