package com.DH.demo.repository;
import com.DH.demo.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository <Paciente, Integer> {
    @Query("SELECT p FROM Paciente p WHERE p.dni=?1")
    Optional<Paciente> buscar(Integer dni);

    @Query("SELECT p FROM Paciente p WHERE p.nombre=?1")
    Optional<List<Paciente>> buscar(String nombre);
}
