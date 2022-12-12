package com.DH.demo.domain.model;
import lombok.*;
import javax.persistence.*;

@Table(name = "domicilios")
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Domicilio {



        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_seq")
        @SequenceGenerator(name = "domicilio_seq", sequenceName = "domicilio_seq", allocationSize = 1)
        @Column

        //Attributes

        private Integer id;

        @Setter
        @Column
        private String calle;

        @Setter
        @Column
        private Integer numero;

        @Setter
        @Column
        private String localidad;

        @Setter
        @Column
        private String provincia;


    }
