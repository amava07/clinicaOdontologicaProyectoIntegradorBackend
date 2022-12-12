package com.DH.demo.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "odontologo")


public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue( strategy = GenerationType.SEQUENCE)

    //Attributes
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String matricula;

    @Column
    private Integer dni;
    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Turno> turnos = new ArrayList<>();


}
