package com.example.demo.modelos;

import javax.persistence.*;

@Entity
@Table(name = "pilotos")
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pilotoId;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private String horasVuelo;
    private String fechaContratacion;
    private String fechaVencimientoLicencia;

    public Long getPilotoId() {
        return pilotoId;
    }

    public void setPilotoId(Long pilotoId) {
        this.pilotoId = pilotoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(String horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(String fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    public Piloto() {

    }
}
