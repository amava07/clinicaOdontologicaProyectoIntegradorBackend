package com.DH.demo.service.impl;
import com.DH.demo.domain.model.Odontologo;
import com.DH.demo.exceptions.InvalidIDException;
import com.DH.demo.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl {

    private final OdontologoRepository odontologoRepository;



    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    //Método Registrar Odontologo
    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);

    }

    //Método Eliminar Odontologo
    public void eliminar(Integer id) throws InvalidIDException {
        if(id != null && id > 0) {
            odontologoRepository.deleteById(Integer.valueOf(id));
        }else {
            throw new InvalidIDException("Id inválido");
        }
    }


    //Método Buscar Id Odontologo
    public Optional <Odontologo> buscar (Integer id) {
        return odontologoRepository.findById(Integer.valueOf(id));
    }

    //Método Buscar Todos
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    //Método actualizar
    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }


}
