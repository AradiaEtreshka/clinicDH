package com.proyect.clinic.controller;

import com.proyect.clinic.exceptions.ErrorDeleteDentistOrPatientException;
import com.proyect.clinic.exceptions.ResourceNotFoundException;
import com.proyect.clinic.model.Dentist;
import com.proyect.clinic.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dentists")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    // Controller para ingresar un nuevo odontologo

    @PostMapping("/newd")
    public ResponseEntity<Dentist> addDentist(@RequestBody Dentist dentist)
    {
        return ResponseEntity.ok(dentistService.saveDentist(dentist));
    }

    //Controller para buscar/traer un odontologo ya ingresado

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> searchDentist(@PathVariable Integer id)
    {
        Dentist dentist = dentistService.searchDentist(id).orElse(null);
        return ResponseEntity.ok(dentist);
    }

    // Controller para traer el listado completo de odontologos

    @GetMapping("/listd")
    public ResponseEntity<List<Dentist>>searchAllPatient()
    {
        return ResponseEntity.ok(dentistService.searchAllDentist());
    }

    // Controller para eliminar un odontologo por id

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Integer id) throws
            ErrorDeleteDentistOrPatientException, ResourceNotFoundException
    {
        ResponseEntity<String> response = null;
        ResponseEntity<Dentist> dentistEval = searchDentist(id);

        if (dentistEval.getBody().getTurnSet().isEmpty())
        {
            if(dentistService.searchDentist(id).isPresent())
            {
                dentistService.deleteDentist(id);
                response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se ha eliminado al Odontologo con la id " + id);
            }
            else
            {
                throw new ResourceNotFoundException("No se ha encontrado el Odontologo con id "+ id
                        +"que desea eliminar, verifique los datos");
            }
        }
        else throw new ErrorDeleteDentistOrPatientException("No puede eliminar el Odonotologo"
        + dentistEval.getBody().getLastName() +" porque este posee turnos asignados. " +
                "Reasigne los turnos antes de volver a intentar");


        return response;
    }

}
