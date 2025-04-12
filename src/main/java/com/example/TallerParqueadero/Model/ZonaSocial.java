package com.example.TallerParqueadero.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ZonaSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zona;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "zonaSocial", cascade = CascadeType.ALL)
    private List<ReservaZona> reservasZona;

    // Constructor vacío
    public ZonaSocial() {
    }

    // Constructor completo
    public ZonaSocial(int id_zona, String nombre, String descripcion, List<ReservaZona> reservasZona) {
        this.id_zona = id_zona;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.reservasZona = reservasZona;
    }

    // Constructor sin ID
    public ZonaSocial(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ZonaSocial(int i, String salónComunal, String espacioCerradoParaEventos) {
    }

    // Getters y setters
    public int getId_zona() {
        return id_zona;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ReservaZona> getReservasZona() {
        return reservasZona;
    }

    public void setReservasZona(List<ReservaZona> reservasZona) {
        this.reservasZona = reservasZona;
    }
}
