package com.example.TallerParqueadero.Service;

import com.example.TallerParqueadero.Model.ReservaParqueadero;
import com.example.TallerParqueadero.Repository.ReservaParqueaderoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservaParqueaderoService {
    private final ReservaParqueaderoRepository repository;

    public ReservaParqueaderoService(ReservaParqueaderoRepository repository) {
        this.repository = repository;
    }
    public List<ReservaParqueadero> CusterReserves() {
        return repository.findAll();
    }

    public Optional<ReservaParqueadero> obtenerReservaPorId(Long id) {
        return repository.findById(id);
    }

    public ReservaParqueadero guardarReserva(ReservaParqueadero reserva) {
        return repository.save(reserva);
    }

    public void eliminarReserva(Long id) {
        repository.deleteById(id);
    }
}
