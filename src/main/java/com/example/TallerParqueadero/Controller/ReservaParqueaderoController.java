package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.ReservaParqueadero;
import com.example.TallerParqueadero.Service.ReservaParqueaderoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas-parqueadero")
@CrossOrigin(origins = "*")
public class ReservaParqueaderoController {

    private final ReservaParqueaderoService service;

    public ReservaParqueaderoController(ReservaParqueaderoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservaParqueadero>> getAll() {
        return ResponseEntity.ok(service.CusterReserves());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaParqueadero> getById(@PathVariable Long id) {
        Optional<ReservaParqueadero> reserva = service.obtenerReservaPorId(id);
        return reserva.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<ReservaParqueadero> create(@RequestBody ReservaParqueadero reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardarReserva(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ReservaParqueadero reserva) {
        Optional<ReservaParqueadero> existente = service.obtenerReservaPorId(id);
        if (existente.isPresent()) {
            reserva.setId(id);
            return ResponseEntity.ok(service.guardarReserva(reserva));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva no encontrada.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<ReservaParqueadero> reserva = service.obtenerReservaPorId(id);
        if (reserva.isPresent()) {
            service.eliminarReserva(id);
            return ResponseEntity.ok("Reserva eliminada correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva no encontrada.");
        }
    }
}
