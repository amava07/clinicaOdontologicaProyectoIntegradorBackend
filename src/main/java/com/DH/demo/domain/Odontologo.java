package com.DH.demo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "odontologo")


public class Odontologo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name = "odontologo_Id")

    //Attributes
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;


}
