package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface visitanteRepository extends JpaRepository<Visitante, Long> {
}
