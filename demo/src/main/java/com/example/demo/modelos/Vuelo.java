package com.example.demo.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vueloId;
    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;
    private String lugarOrigen;
    private String lugarDestino;
    private String fechaSalida;
    private String fechaLlegada;
    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;
}
