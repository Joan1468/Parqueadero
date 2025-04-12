package com.example.TallerParqueadero.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ReservaZona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;

    private LocalDate fecha;
    private LocalTime hora_inicio;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private propietario propietario;

    @ManyToOne
    @JoinColumn(name = "id_zona")
    private ZonaSocial zonaSocial;

    // Constructor vacío
    public ReservaZona() {
    }

    // Constructor completo con ID
    public ReservaZona(int id_reserva, LocalDate fecha, LocalTime hora_inicio, propietario propietario, ZonaSocial zonaSocial) {
        this.id_reserva = id_reserva;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.propietario = propietario;
        this.zonaSocial = zonaSocial;
    }

    // Constructor útil para DataLoader (sin ID)
    public ReservaZona(LocalDate fecha, LocalTime hora_inicio, propietario propietario, ZonaSocial zonaSocial) {
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.propietario = propietario;
        this.zonaSocial = zonaSocial;
    }

    // Getters y Setters

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public void setId(Long id) {
    }
}
