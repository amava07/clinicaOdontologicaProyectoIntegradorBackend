package com.DH.demo.service.impl;
import com.DH.demo.domain.model.Paciente;
import com.DH.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl {

    private final PacienteRepository pacienteRepository;


    @Autowired
    public PacienteServiceImpl (PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    //Método Registrar Paciente
    public Paciente registrarPaciente ( Paciente paciente ){
        return pacienteRepository.save (paciente);
    }


    //Método Eliminar Paciente
    public void eliminar(Integer id) {
        pacienteRepository.deleteById(Integer.valueOf(id));
    }

    //Método Buscar Id Paciente
    public Optional<Paciente> buscar (Integer id){
        return pacienteRepository.findById(Integer.valueOf(id));
    }

    //Método Buscar Todos
    public List<Paciente> buscarTodos(){
        return pacienteRepository.findAll();
    }

    //Método actualizar
    public Paciente actualizar (Paciente paciente){
        return pacienteRepository.save(paciente);
    }

}
