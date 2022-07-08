package com.proyect.clinic.controller;

import com.proyect.clinic.model.Turn;
import com.proyect.clinic.service.TurnService;
import com.proyect.clinic.service.DentistService;
import com.proyect.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnController {

    private final TurnService turnService;
    private final DentistService dentistService;
    private final PatientService patientService;

    @Autowired
    public TurnController(TurnService turnService, DentistService dentistService, PatientService patientService) {
        this.turnService = turnService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    @PostMapping("/newdate")
    public ResponseEntity<Turn> newDate(@RequestBody Turn turn)
    {
        ResponseEntity<Turn> response;

        if (patientService.searchPatient(turn.getPatient().getId()).isPresent() &&
                dentistService.searchDentist(turn.getDentist().getId()).isPresent())
        {
            response = ResponseEntity.ok(turnService.saveDate(turn));
        }
        else
        {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return response;
    }

    @GetMapping("/listturns")
    public ResponseEntity<List<Turn>> listAllDates()
    {
        return ResponseEntity.ok(turnService.searchAllDate());
    }

    public ResponseEntity<String> deleteDate(@PathVariable Integer id)
    {
        ResponseEntity<String> response;

        if(turnService.searchDate(id).isPresent())
        {
            turnService.deleteDate(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Turno Eliminado");
        }
        else
        {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El turno indicado no existe");
        }
        return response;
    }
}
