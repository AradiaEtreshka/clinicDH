package com.proyect.clinic.service;

import com.proyect.clinic.model.Residence;
import com.proyect.clinic.repository.ResidenceRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidenceService {

    private final ResidenceRepository residenceRepository;

    //LOGGER
    private static final Logger LOGGER = Logger.getLogger(Residence.class);

    @Autowired
    public ResidenceService(ResidenceRepository residenceRepository) {
        this.residenceRepository = residenceRepository;
    }


    // CRUD DOMICILIO

    public Residence saveResidence(Residence address)
    {
        residenceRepository.save(address);
        LOGGER.info("Se ha guardado el domicilio con exito");
        return address;
    }

    public Optional<Residence> searchResidence(Integer id)
    {
        return Optional.of(residenceRepository.getById(Integer.valueOf(id)));
    }

    public List<Residence> searchAllresidence(){
        return residenceRepository.findAll();
    }

    public void deleteResidence(Integer id)
    {
        residenceRepository.deleteById(Integer.valueOf(id));
    }
}
