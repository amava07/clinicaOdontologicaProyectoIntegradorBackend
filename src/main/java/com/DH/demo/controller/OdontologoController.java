package com.DH.demo.controller;
import com.DH.demo.domain.dto.OdontologoDTO;
import com.DH.demo.service.DomicilioService;
import com.DH.demo.service.OdontologoService;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/v1/odontologos")

public class OdontologoController {

    private final static Logger logger = Logger.getLogger(DomicilioService.class);
    @Autowired
    private OdontologoService service;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> addNew(@RequestBody OdontologoDTO odontologo){
        ResponseEntity<Object> respuesta = null;

        try {
            odontologo = service.createNew(odontologo);
            respuesta = ResponseEntity.ok(odontologo);
        } catch (ServiceException ex) {
            respuesta = ResponseEntity.badRequest().body(ex.getMessage());
        }
        logger.info("peticion para crear nuevo odontologo");
        return respuesta;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDTO>> listarTodos(){
        List<OdontologoDTO> resultado = service.getAll();
        logger.info(" Listar todos los odontologos creados");
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) throws ServiceException {
        service.eliminar(Integer.parseInt(id));
        return ResponseEntity.ok("Se eliminó el odontólogo id número " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarPorId(@PathVariable Integer id) throws ServiceException{
        OdontologoDTO odontologo = service.getById(id);
        return ResponseEntity.ok(odontologo);
    }

}
