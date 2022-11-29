package com.DH.demo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "paciente")



    public class Paciente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column ( name = "paciente_Id")


        //Attributes
        private Integer id;
        private String nombre;
        private String apellido;
        private String domicilio;
        private Integer dni;
        private LocalDateTime fechaDeAlta;

}

