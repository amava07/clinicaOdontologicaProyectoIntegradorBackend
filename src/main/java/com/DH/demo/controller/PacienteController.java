package com.DH.demo.controller;
import com.DH.demo.domain.dto.PacienteDTO;
import com.DH.demo.domain.model.Paciente;
import com.DH.demo.service.DomicilioService;
import com.DH.demo.service.PacienteService;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/pacientes")

public class PacienteController {

    private final static Logger logger = Logger.getLogger(DomicilioService.class);
    @Autowired
    private PacienteService service;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> addNew(@RequestBody PacienteDTO paciente){
        ResponseEntity<Object> respuesta = null;

        try {
            paciente = service.createNew(paciente);
            respuesta = ResponseEntity.ok(paciente);
        } catch (ServiceException ex) {
            respuesta = ResponseEntity.badRequest().body(ex.getMessage());
        }
        logger.info("peticion para crear nuevo paciente");
        return respuesta;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PacienteDTO>> listarTodos(){
        List<PacienteDTO> resultado = service.getAll();
        logger.info("peticion para listar todos los pacientes");
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) throws ServiceException {
        service.eliminar(Integer.parseInt(id));
        return ResponseEntity.ok("Se eliminó el paciente con id " + id);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> buscarTodos() {
        return ResponseEntity.ok(service.getAll());
    }

}
