package com.proyect.clinic.controller;

import com.proyect.clinic.model.Patient;
import com.proyect.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

// Controller para ingresar un nuevo paciente

    @PostMapping("/newp")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient newPatient)
    {
        return ResponseEntity.ok(patientService.savePatient(newPatient));
    }

    //Controller para buscar/traer un paciente ya ingresado

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchPatient(@PathVariable Integer id)
    {
        Patient patient = patientService.searchPatient(id).orElse(null);
        return ResponseEntity.ok(patient);
    }

    // Controller para traer el listado completo de pacientes

    @GetMapping("/listp")
    public ResponseEntity<List<Patient>>searchAllPatient()
    {
        return ResponseEntity.ok(patientService.searchAllPatient());
    }

    // Controller para eliminar un paciente por id

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id)
    {
        ResponseEntity<String> response = null;

        if(patientService.searchPatient(id).isPresent())
        {
            patientService.deletePatient(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se ha eliminado al Paciente con la id " + id);
        }
        else
        {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El paciente buscado no existe");
        }

        return response;
    }

}
