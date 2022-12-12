package com.DH.demo.domain.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class PacienteDTO implements DTO {


    private  Integer id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer dni;
    private LocalDate fechaDeAlta;

}
