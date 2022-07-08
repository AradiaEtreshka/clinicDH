package com.proyect.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Domicilio")
public class Residence {

    //Attributes

    @Id
    @SequenceGenerator(name = "residence_sequence", sequenceName = "residence_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "residence_sequence")
    private Integer id;
    private String street;
    private Integer number;
    private String state;
    private String province;

    //Constructors

    public Residence() {
    }

    public Residence(String street, Integer number, String state, String province, Patient patient) {
        this.street = street;
        this.number = number;
        this.state = state;
        this.province = province;
    }
}
