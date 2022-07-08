package com.proyect.clinic.service;

import com.proyect.clinic.model.Patient;
import com.proyect.clinic.repository.PatientRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    //LOGGER
    private static final Logger LOGGER = Logger.getLogger(Patient.class);

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // CRUD PACIENTE

    public Patient savePatient(Patient newPatient)
    {
        patientRepository.save(newPatient);
        LOGGER.info("Se registro un nuevo Paciente");
        return newPatient;

    }

    public Optional<Patient> searchPatient(Integer id)
    {
        return patientRepository.findById(id);
    }

    public List<Patient> searchAllPatient()
    {
        return patientRepository.findAll();
    }

    public void deletePatient(Integer id)
    {
        patientRepository.deleteById(Integer.valueOf(id));
        LOGGER.info("Se ha eliminado al paciente con id " + id);
    }
}
