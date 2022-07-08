package com.proyect.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Paciente")
public class Patient {

    //Attributes

    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Integer id;

    @Column(name = "Nombre")
    private String name;
    @Column(name = "Apellido")
    private String lastName;
    @Column(name = "DNI")
    private Integer dni;
    @Column(name = "Fecha_de_Admision")
    private java.util.Date admission;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Residence residence;

    @OneToMany(mappedBy = "patient")
    private Set<Turn> turnSet = new HashSet<>();

    //Constructors

    public Patient() {
    }

//    public Patient(String name, String lastName, Integer dni, java.util.Date admission) {
//        this.name = name;
//        this.lastName = lastName;
//        this.dni = dni;
//        this.admission = admission;
//
//    }


    public Patient(String name, String lastName, Integer dni, Date admission, Residence residence) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.admission = admission;
        this.residence = residence;
    }
}
