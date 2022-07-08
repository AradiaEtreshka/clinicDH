package com.proyect.clinic.service;

import com.proyect.clinic.exceptions.ErrorDeleteDentistOrPatientException;
import com.proyect.clinic.exceptions.ResourceNotFoundException;
import com.proyect.clinic.model.Dentist;
import com.proyect.clinic.repository.DentistRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private  final DentistRepository dentistRepository;

    //LOGGER
    private static final Logger LOGGER = Logger.getLogger(Dentist.class);


    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    //CRUD

    public Dentist saveDentist(Dentist newDentist)
    {
        dentistRepository.save(newDentist);
        LOGGER.info("Se ha guardado el nuevo Odontologo con exito");
        return newDentist;
    }

    public Optional<Dentist> searchDentist(Integer id)
    {
        return dentistRepository.findById(Integer.valueOf(id));
    }

    public List<Dentist> searchAllDentist()
    {
        return dentistRepository.findAll();
    }

    public void deleteDentist(Integer id) throws ResourceNotFoundException, ErrorDeleteDentistOrPatientException
    {

        if(searchDentist(id) == null)
        {
            throw new ResourceNotFoundException("No se encuentra el " +
                    "ODONTOLOGO que desea eliminar");
        }
        else
        {
            dentistRepository.deleteById(id);
            LOGGER.info("Se ha eliminado al Odontologo con id nro" + id);
        }
    }
}
