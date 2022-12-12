package com.DH.demo.domain.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)

public class OdontologoDTO implements  DTO{

    private Integer id;
    private Integer dni;
    private String nombre;
    private String apellido;
    private String matricula;



}
