package com.DH.demo.repository;

import com.DH.demo.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Integer> {
}