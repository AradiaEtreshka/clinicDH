package com.proyect.clinic.service;

import com.proyect.clinic.model.Turn;
import com.proyect.clinic.repository.TurnRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnService {

    private final TurnRepository turnRepository;

    //LOGGER
    private static final Logger LOGGER = Logger.getLogger(Turn.class);

    @Autowired
    public TurnService(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    // CRUD

    public Turn saveDate(Turn newTurn)
    {
        turnRepository.save(newTurn);
        LOGGER.info("Se ha creado un nuevo turno");
        return newTurn;
    }

    public Optional<Turn> searchDate(Integer id)
    {
        return turnRepository.findById(Integer.valueOf(id));
    }

    public List<Turn> searchAllDate()
    {
        return turnRepository.findAll();
    }

    public void deleteDate(Integer id)
    {
        turnRepository.deleteById(id);
    }
}
