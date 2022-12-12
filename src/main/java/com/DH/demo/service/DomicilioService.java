package com.DH.demo.service;
import com.DH.demo.domain.dto.DomicilioDTO;
import com.DH.demo.domain.model.Domicilio;
import com.DH.demo.repository.DomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomicilioService implements ApiClinicService< DomicilioDTO > {

    private final static Logger logger = Logger.getLogger(DomicilioService.class);

    @Autowired
    private MapperConfig mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DomicilioRepository repository;

    public DomicilioService(MapperConfig mapper, ObjectMapper objectMapper, DomicilioRepository repository) {
        this.mapper = mapper;
        this.objectMapper = objectMapper;
        this.repository = repository;
    }

    @Override
    public DomicilioDTO createNew(DomicilioDTO dto) throws ServiceException {
        Domicilio domicilio = null;

        if(dto.getId() != null) {
            domicilio = repository.save(mapper.getModelMapper().map(dto, Domicilio.class));
        }else{
            throw new ServiceException("El odontólogo debe tener un número de matrícula.");
        }
        logger.info("Se creó un domicilio");
        return mapper.getModelMapper().map(domicilio,  DomicilioDTO.class);
    }

    @Override
    public List<DomicilioDTO> getAll() {
        List<DomicilioDTO> resultado = new ArrayList<>();

        List<Domicilio> entidades = repository.findAll();

        entidades.forEach(e -> resultado.add(mapper.getModelMapper().map(e, DomicilioDTO.class)));
        logger.info("Lista de domicilios");
        return resultado;
    }

    @Override
    public void eliminar(Integer id) throws ServiceException {
        if (id == null || id < 1)
            throw new ServiceException("El id del domicilio no puede ser null ni negativo");
        if (!repository.existsById(id))
            throw new ServiceException("No existe ningún domicilio registrado con id: " + id);
        repository.deleteById(id);
    }

    @Override
    public DomicilioDTO getById(Integer id) throws ServiceException {
        if (id == null || id < 1)
            throw new ServiceException("El campo ID del Domicilio no acepta campo vacío o númerp negativo");
        Domicilio domicilio = repository.findById(id).orElse(null);
        if (domicilio == null)
            throw new ServiceException("No se encontró el domicilio con id " + id);

        return mapper.getModelMapper().map(domicilio, DomicilioDTO.class);
    }
}
