package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.Visitante;
import com.example.TallerParqueadero.Service.VisitanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visitantes")
@CrossOrigin(origins = "*")
public class VisitanteController {

    private final VisitanteService visitanteService;

    public VisitanteController(VisitanteService visitanteService) {
        this.visitanteService = visitanteService;
    }

    @GetMapping
    public ResponseEntity<List<Visitante>> getAllVisitantes() {
        return ResponseEntity.ok(visitanteService.listarVisitantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitante> getVisitanteById(@PathVariable Long id) {
        Optional<Visitante> visitante = visitanteService.obtenerVisitantePorId(id);
        return visitante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Visitante> createVisitante(@RequestBody Visitante visitante) {
        Visitante nuevo = visitanteService.guardarVisitante(visitante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVisitante(@PathVariable Long id, @RequestBody Visitante visitante) {
        Optional<Visitante> existente = visitanteService.obtenerVisitantePorId(id);
        if (existente.isPresent()) {
            visitante.setId(id);
            Visitante actualizado = visitanteService.guardarVisitante(visitante);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitante no encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVisitante(@PathVariable Long id) {
        Optional<Visitante> visitante = visitanteService.obtenerVisitantePorId(id);
        if (visitante.isPresent()) {
            visitanteService.eliminarVisitante(id);
            return ResponseEntity.ok("Visitante eliminado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitante no encontrado.");
        }
    }
}
