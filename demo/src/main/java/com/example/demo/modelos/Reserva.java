package com.example.demo.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservaId;
    private String fechaReserva;
    private String nombreClase;
    private double precioClase;
    private String numeroAsiento;
    private String numeroEmbarque;
    private String puertaEmbarque;
    private int numeroMochila;
    private double pesoMochila;
    @ManyToOne
    @JoinColumn(name = "pasajero_id")
    private Pasajero pasajero;
    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;
    @ManyToOne
    @JoinColumn(name = "id")
    private Usuario usuario;
}
