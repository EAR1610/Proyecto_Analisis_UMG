package com.example.demo.modelos;

import javax.persistence.*;

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

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Vuelo() {

    }
}
