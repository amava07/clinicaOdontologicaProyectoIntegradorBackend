package com.DH.demo.controller;
import com.DH.demo.domain.model.Paciente;
import com.DH.demo.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/pacientes")

public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping("/registar")
    public ResponseEntity<Paciente> registrarPaciente (@RequestBody Paciente paciente){
        return  ResponseEntity.ok(pacienteService.registrarPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar (@PathVariable Integer id){
        Paciente paciente = pacienteService.buscar(id).orElse(null);
        return ResponseEntity.ok(paciente);
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Paciente> actualizar (@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response = null;
        if(paciente.getId() != null && pacienteService.buscar(paciente.getId()).isPresent() )
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if (pacienteService.buscar(id).isPresent()){
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente Eliminado");

        } else response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

}
