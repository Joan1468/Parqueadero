package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.ZonaSocial;
import com.example.TallerParqueadero.Service.ZonaSocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zonas-sociales")
@CrossOrigin(origins = "*")
public class ZonaSocialController {

    private final ZonaSocialService service;

    public ZonaSocialController(ZonaSocialService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ZonaSocial>> getAll() {
        return ResponseEntity.ok(service.listarZonasSociales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZonaSocial> getById(@PathVariable Long id) {
        Optional<ZonaSocial> zona = service.obtenerZonaSocialPorId(id);
        return zona.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<ZonaSocial> create(@RequestBody ZonaSocial zona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardarZonaSocial(zona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ZonaSocial zona) {
        Optional<ZonaSocial> existente = service.obtenerZonaSocialPorId(id);
        if (existente.isPresent()) {
            zona.setId(id);
            return ResponseEntity.ok(service.guardarZonaSocial(zona));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Zona social no encontrada.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<ZonaSocial> zona = service.obtenerZonaSocialPorId(id);
        if (zona.isPresent()) {
            service.eliminarZonaSocial(id);
            return ResponseEntity.ok("Zona social eliminada correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Zona social no encontrada.");
        }
    }
}
