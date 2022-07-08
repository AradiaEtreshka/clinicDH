package com.proyect.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table (name = "Dentista")
public class Dentist {

    //Attributes

    @Id
    @SequenceGenerator(name = "dentist_sequence", sequenceName = "dentist_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_sequence")
    private Integer id;
    private String name;
    private String lastName;
    private Integer registration_number;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Turn> turnSet = new HashSet<>();

    //Constructors

    public Dentist() {
    }

    public Dentist(String name, String lastName, Integer registration_number, Set<Turn> turnSet) {
        this.name = name;
        this.lastName = lastName;
        this.registration_number = registration_number;
        this.turnSet = turnSet;
    }
}
