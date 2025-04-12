package com.example.TallerParqueadero.Service;

import com.example.TallerParqueadero.Model.*;
import com.example.TallerParqueadero.Repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final propietarioRepository propietarioRepository;
    private final visitanteRepository visitanteRepository;
    private final ZonaSocialRepository zonaSocialRepository;
    private final ReservaParqueaderoRepository reservaParqueaderoRepository;
    private final ReservaZonaRepository reservaZonaRepository;

    public DataLoader(
            propietarioRepository propietarioRepository,
            visitanteRepository visitanteRepository,
            ZonaSocialRepository zonaSocialRepository,
            ReservaParqueaderoRepository reservaParqueaderoRepository,
            ReservaZonaRepository reservaZonaRepository
    ) {
        this.propietarioRepository = propietarioRepository;
        this.visitanteRepository = visitanteRepository;
        this.zonaSocialRepository = zonaSocialRepository;
        this.reservaParqueaderoRepository = reservaParqueaderoRepository;
        this.reservaZonaRepository = reservaZonaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // ----- PROPIETARIOS -----
        propietarioRepository.save(new propietario(0, "Carlos Ruiz", "1111", LocalDate.now(), LocalTime.of(8, 30)));
        propietarioRepository.save(new propietario(0, "Marta Diaz", "2222", LocalDate.now(), LocalTime.of(9, 0)));
        propietarioRepository.save(new propietario(0, "Luis Mejía", "3333", LocalDate.now(), LocalTime.of(10, 0)));
        propietarioRepository.save(new propietario(0, "Ana Torres", "4444", LocalDate.now(), LocalTime.of(11, 30)));
        propietarioRepository.save(new propietario(0, "Jorge Gómez", "5555", LocalDate.now(), LocalTime.of(12, 45)));

        // ----- VISITANTES -----
        visitanteRepository.save(new Visitante(0, "Laura Sánchez", "7777", LocalDate.now(), LocalTime.of(9, 15)));
        visitanteRepository.save(new Visitante(0, "Pedro Rojas", "8888", LocalDate.now(), LocalTime.of(10, 45)));
        visitanteRepository.save(new Visitante(0, "Sofía Ramírez", "9999", LocalDate.now(), LocalTime.of(11, 10)));
        visitanteRepository.save(new Visitante(0, "Daniel Ortega", "1010", LocalDate.now(), LocalTime.of(12, 20)));
        visitanteRepository.save(new Visitante(0, "Carmen Herrera", "1212", LocalDate.now(), LocalTime.of(13, 5)));

        // ----- ZONAS SOCIALES -----
        zonaSocialRepository.save(new ZonaSocial(0, "Salón Comunal", "Espacio cerrado para eventos"));
        zonaSocialRepository.save(new ZonaSocial(0, "Cancha de Fútbol", "Área para actividades deportivas"));
        zonaSocialRepository.save(new ZonaSocial(0, "Piscina", "Zona acuática recreativa"));
        zonaSocialRepository.save(new ZonaSocial(0, "Parque Infantil", "Juegos para niños"));
        zonaSocialRepository.save(new ZonaSocial(0, "Gimnasio", "Área para entrenamiento físico"));

        // ----- RESERVAS PARQUEADERO -----
        reservaParqueaderoRepository.save(new ReservaParqueadero(0, "AAA123", "1111", LocalDate.now()));
        reservaParqueaderoRepository.save(new ReservaParqueadero(0, "BBB234", "2222", LocalDate.now()));
        reservaParqueaderoRepository.save(new ReservaParqueadero(0, "CCC345", "3333", LocalDate.now()));
        reservaParqueaderoRepository.save(new ReservaParqueadero(0, "DDD456", "4444", LocalDate.now()));
        reservaParqueaderoRepository.save(new ReservaParqueadero(0, "EEE567", "5555", LocalDate.now()));

        // ----- RESERVAS ZONA -----
        reservaZonaRepository.save(new ReservaZona(0, "1111", "Salón Comunal", LocalDate.now()));
        reservaZonaRepository.save(new ReservaZona(0, "2222", "Piscina", LocalDate.now()));
        reservaZonaRepository.save(new ReservaZona(0, "3333", "Gimnasio", LocalDate.now()));
        reservaZonaRepository.save(new ReservaZona(0, "4444", "Cancha de Fútbol", LocalDate.now()));
        reservaZonaRepository.save(new ReservaZona(0, "5555", "Parque Infantil", LocalDate.now()));

        System.out.println("✅ Datos de prueba cargados correctamente en el sistema de parqueadero.");
    }
}
