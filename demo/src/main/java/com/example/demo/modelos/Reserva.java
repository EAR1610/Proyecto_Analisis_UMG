package com.example.demo.modelos;

import javax.persistence.*;

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

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public double getPrecioClase() {
        return precioClase;
    }

    public void setPrecioClase(double precioClase) {
        this.precioClase = precioClase;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getNumeroEmbarque() {
        return numeroEmbarque;
    }

    public void setNumeroEmbarque(String numeroEmbarque) {
        this.numeroEmbarque = numeroEmbarque;
    }

    public String getPuertaEmbarque() {
        return puertaEmbarque;
    }

    public void setPuertaEmbarque(String puertaEmbarque) {
        this.puertaEmbarque = puertaEmbarque;
    }

    public int getNumeroMochila() {
        return numeroMochila;
    }

    public void setNumeroMochila(int numeroMochila) {
        this.numeroMochila = numeroMochila;
    }

    public double getPesoMochila() {
        return pesoMochila;
    }

    public void setPesoMochila(double pesoMochila) {
        this.pesoMochila = pesoMochila;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reserva() {

    }
}
