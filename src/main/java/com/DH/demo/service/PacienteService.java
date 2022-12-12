package com.DH.demo.service;

import com.DH.demo.domain.dto.PacienteDTO;
import com.DH.demo.domain.model.Paciente;
import com.DH.demo.repository.PacienteRepository;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements ApiClinicService<PacienteDTO>{

    private final static Logger logger = Logger.getLogger(PacienteService.class);
    @Autowired
    private MapperConfig mapper;

    @Autowired
    private PacienteRepository repository;

    @Override
    public PacienteDTO createNew(PacienteDTO dto) throws ServiceException {
        Paciente entidad = null;

        if(!dto.getNombre().isBlank()) {
            entidad = repository.save(mapper.getModelMapper().map(dto, Paciente.class));
            logger.info("Se creó un paciente");
        }else{
            throw new ServiceException("El paciente debe tener un número de DNI.");
        }

        return mapper.getModelMapper().map(entidad, PacienteDTO.class);
    }

    @Override
    public List<PacienteDTO> getAll(){
        List<PacienteDTO> resultado = new ArrayList<>();

        List<Paciente> entidades = repository.findAll();

        entidades.forEach(e -> resultado.add(mapper.getModelMapper().map(e, PacienteDTO.class)));
        logger.info("Se listaron los pacientes ");
        return resultado;
    }

    @Override
    public void eliminar(Integer id) throws ServiceException {
        if (id == null || id < 1)
            throw new ServiceException("El id del paciente no puede ser null o negativo");
        if (!repository.existsById(id))
            throw new ServiceException("No se encontró ningún paciente con id: " + id);
        repository.deleteById(id);
    }

    @Override
    public PacienteDTO getById(Integer id){
        Optional<Paciente> p = repository.findById(id);
        logger.info("Se encontro un paciente con el  id ");
        return p.isPresent() ? mapper.getModelMapper().map(p.get(), PacienteDTO.class) : null;
    }


}
