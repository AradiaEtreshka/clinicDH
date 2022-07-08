package com.proyect.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "Turnos")
public class Turn {

    //Attributes

    @Id

    @SequenceGenerator(name = "turn_sequence", sequenceName = "turn_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turn_sequence")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @Column(name = "Fecha")
    private java.util.Date day_hour;

    // Constructors


    public Turn() {
    }
    public Turn(Patient patient, Dentist dentist, java.util.Date day_hour) {
        this.patient = patient;
        this.dentist = dentist;
        this.day_hour = day_hour;
    }

    @Override
    public String toString() {
        return "La fecha de su turno es: " + day_hour + " con el odontologo " + dentist;
    }
}
