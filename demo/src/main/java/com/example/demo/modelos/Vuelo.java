package com.example.demo.modelos;

import javax.persistence.*;

@Entity
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vueloId;
    private String lugarOrigen;
    private String lugarDestino;
    private String fechaSalida;
    private String fechaLlegada;

    @OneToOne()
    private Avion avion;

}
