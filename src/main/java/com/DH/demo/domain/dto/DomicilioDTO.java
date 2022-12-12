package com.DH.demo.domain.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class DomicilioDTO implements DTO {

    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

    public DomicilioDTO() {
    }

    public DomicilioDTO(Integer id, String calle, Integer numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

}
