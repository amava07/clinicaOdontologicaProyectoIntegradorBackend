package com.DH.demo.domain.dto;

import java.time.LocalDate;

public class TurnoDTO implements DTO {

    private Integer id;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;
    private LocalDate fecha;

    public TurnoDTO(){

    }

    public TurnoDTO(Integer id, PacienteDTO paciente, OdontologoDTO odontologo, LocalDate fecha) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public OdontologoDTO getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoDTO odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

