package org.example.mutant.Repositories;

import org.example.mutant.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Long> {

    long countByIsMutantTrue();

    long countByIsMutantFalse();

}
