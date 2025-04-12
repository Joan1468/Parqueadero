package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.propietario;
import com.example.TallerParqueadero.Service.PropietarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propietarios")
@CrossOrigin(origins = "*")
public class PropietarioController {
    private final PropietarioService propietarioService;
    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }
    @GetMapping
    public ResponseEntity<List<propietario>> getAllPropietarios() {
        return ResponseEntity.ok(propietarioService.listarPropietarios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<propietario> getpropietarioById(@PathVariable Long id) {
        Optional<propietario> propietario = propietarioService.obtenerpropietarioPorId(id);
        return propietario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<propietario> createPropietario(@RequestBody propietario propietario) {
        propietario nuevo = propietarioService.guardarpropietario(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePropietario(@PathVariable Long id, @RequestBody propietario propietario) {
        Optional<propietario> existente = propietarioService.obtenerPropietarioPorId(id);
        if (existente.isPresent()) {
            propietario.setId(id);
            propietario actualizado = propietarioService.guardarPropietario(propietario);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propietario no encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePropietario(@PathVariable Long id) {
        Optional<propietario> propietario = propietarioService.obtenerPropietarioPorId(id);
        if (propietario.isPresent()) {
            propietarioService.eliminarPropietario(id);
            return ResponseEntity.ok("Propietario eliminado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propietario no encontrado.");
        }
    }
}
