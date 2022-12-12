package com.DH.demo.service;
import com.DH.demo.domain.dto.OdontologoDTO;
import com.DH.demo.domain.model.Odontologo;
import com.DH.demo.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements ApiClinicService<OdontologoDTO>{

    private final static Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    private MapperConfig mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OdontologoRepository repository;



    @Override
    public OdontologoDTO createNew(OdontologoDTO dto) throws ServiceException {
        if (dto == null)
            throw new ServiceException("El campo odontólogo no puede ser null");
        Odontologo odontologo = mapper.getModelMapper().map(dto, Odontologo.class);
        return mapper.getModelMapper().map(repository.save(odontologo), OdontologoDTO.class);
    }

    @Override
    public List<OdontologoDTO> getAll() {
        List<OdontologoDTO> resultado = new ArrayList<>();

        List<Odontologo> entidades = repository.findAll();

        entidades.forEach(e -> resultado.add(mapper.getModelMapper().map(e, OdontologoDTO.class)));
        logger.info("Lista de odontólogos");
        return resultado;
    }

    @Override
    public OdontologoDTO getById(Integer id){
        Optional<Odontologo> p = repository.findById(id);
        logger.info("odontólogo por id encontrado");
        return p.isPresent() ? mapper.getModelMapper().map(p.get(), OdontologoDTO.class) : null;
    }

    @Override
    public void eliminar(Integer id) throws ServiceException {
        if (id == null || id < 1)
            throw new ServiceException("El campo id del odontólogo no puede ser null o negativo");
        if (!repository.existsById(id))
            throw new ServiceException("No se encontró ningún odontólogo con id: " + id);
        repository.deleteById(id);
    }

}
