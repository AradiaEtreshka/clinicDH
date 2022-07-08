package com.proyect.clinic.repository;

import com.proyect.clinic.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Integer> {
}
