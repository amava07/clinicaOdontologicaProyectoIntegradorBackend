package com.DH.demo.service.impl;
import com.DH.demo.domain.Odontologo;
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
    public void eliminar(Integer id) {
        odontologoRepository.deleteById(Integer.valueOf(id));
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
