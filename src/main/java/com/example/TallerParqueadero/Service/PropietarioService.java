package com.example.TallerParqueadero.Service;
import com.example.TallerParqueadero.Model.propietario;
import com.example.TallerParqueadero.Repository.propietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PropietarioService {
    @Autowired
    private propietarioRepository propietarioRepository;

    public List<propietario> listarPropietarios() {
        return propietarioRepository.findAll();
    }
    public Optional<propietario> obtenerPropietarioPorId(Long id) {
        return propietarioRepository.findById(id);
    }
    public propietario guardarPropietario(propietario propietario) {
        return propietarioRepository.save(propietario);
    }
    public void eliminarPropietario(Long id) {
        propietarioRepository.deleteById(id);
    }
}
