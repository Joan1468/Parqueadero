package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.ReservaParqueadero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaParqueaderoRepository extends JpaRepository<ReservaParqueadero, Long> {
}
