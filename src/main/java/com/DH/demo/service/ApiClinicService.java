package com.DH.demo.service;
import com.DH.demo.domain.dto.DTO;
import org.hibernate.service.spi.ServiceException;

import java.util.List;


public interface ApiClinicService <D extends DTO>{
    D createNew(D dto) throws ServiceException;
    List<D> getAll();

    void eliminar (Integer id) throws ServiceException;

    D getById(Integer id) throws ServiceException;

}
