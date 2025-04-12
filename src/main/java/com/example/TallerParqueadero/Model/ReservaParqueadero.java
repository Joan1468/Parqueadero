package com.example.TallerParqueadero.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ReservaParqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;

    private LocalDate fecha;
    private LocalTime hora_inicio;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    // Constructor vacío (obligatorio para JPA)
    public ReservaParqueadero() {
    }

    // Constructor completo
    public <propietario> ReservaParqueadero(int id_reserva, LocalDate fecha, LocalTime hora_inicio, propietario propietario) {
        this.id_reserva = id_reserva;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.propietario = propietario;
    }

    // Constructor útil para carga sin ID
    public <propietario> ReservaParqueadero(LocalDate fecha, LocalTime hora_inicio, propietario propietario) {
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.propietario = (Propietario) propietario;
    }

    // Getters y Setters

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public <propietario> propietario getPropietario() {
        return (propietario) propietario;
    }

    public void setPropietario(propietario propietario) {
        this.propietario = propietario;
    }

    public void setId(Long id) {
    }
}
