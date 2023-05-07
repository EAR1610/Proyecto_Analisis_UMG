package com.example.demo.modelos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facturaId;
    private String tipoPago;
    private double total;
    private String fechaEmision;
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Factura() {

    }
}
