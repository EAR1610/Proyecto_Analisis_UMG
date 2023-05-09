package com.example.demo.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
