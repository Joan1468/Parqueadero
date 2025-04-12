package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.ReservaZona;
import com.example.TallerParqueadero.Model.ReservaZona;
import com.example.TallerParqueadero.Service.ReservaZonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas-zona")
@CrossOrigin(origins = "*")
public class ReservaZonaController {

    private final ReservaZonaService service;

    public ReservaZonaController(ReservaZonaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservaZona>> getAll() {
        return ResponseEntity.ok(service.listarReservasZona());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaZona> getById(@PathVariable Long id) {
        Optional<ReservaZona> reserva = service.obtenerReservaZonaPorId(id);
        return reserva.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<ReservaZona> create(@RequestBody ReservaZona reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardarReservaZona(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ReservaZona reserva) {
        Optional<ReservaZona> existente = service.obtenerReservaZonaPorId(id);
        if (existente.isPresent()) {
            reserva.setId(id);
            return ResponseEntity.ok(service.guardarReservaZona(reserva));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva no encontrada.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<ReservaZona> reserva = service.obtenerReservaZonaPorId(id);
        if (reserva.isPresent()) {
            service.eliminarReservaZona(id);
            return ResponseEntity.ok("Reserva de zona eliminada correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva no encontrada.");
        }
    }
}
