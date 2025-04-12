package com.example.TallerParqueadero.Service;

import com.example.TallerParqueadero.Model.ReservaZona;
import com.example.TallerParqueadero.Repository.ReservaZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaZonaService {

    @Autowired
    private ReservaZonaRepository reservaZonaRepository; // ✅ Instancia, no clase

    public List<ReservaZona> listarReservasZona() {
        return reservaZonaRepository.findAll(); // ✅ Llamada correcta
    }

    public Optional<ReservaZona> obtenerReservaZonaPorId(Long id) {
        return reservaZonaRepository.findById(id);
    }

    public ReservaZona guardarReservaZona(ReservaZona reservaZona) {
        return reservaZonaRepository.save(reservaZona);
    }

    public void eliminarReservaZona(Long id) {
        reservaZonaRepository.deleteById(id);
    }
}
