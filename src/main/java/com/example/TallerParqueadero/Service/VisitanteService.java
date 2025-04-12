package com.example.TallerParqueadero.Service;
import com.example.TallerParqueadero.Model.Visitante;
import com.example.TallerParqueadero.Repository.visitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class VisitanteService {
    @Autowired
    private visitanteRepository visitanteRepository;
    public List<Visitante> listarVisitantes() {
        return visitanteRepository.findAll();
    }
    public Optional<Visitante> obtenerVisitantePorId(Long id) {
        return visitanteRepository.findById(id);
    }
    public Visitante guardarVisitante(Visitante visitante) {
        return visitanteRepository.save(visitante);
    }
    public void eliminarvisitante(Long id) {
        visitanteRepository.deleteById(id);
    }
}
