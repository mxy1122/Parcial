package org.example.mutant.Service;

import org.example.mutant.Entities.Persona;
import org.example.mutant.Repositories.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonaServiceTest {

    @InjectMocks
    private PersonaService personaService;

    @Mock
    private PersonaRepository personaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMutant_cuandoElAdnMutante_regresaVerdadero() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };

        assertTrue(personaService.mutant(dna), "Should return true for mutant DNA");
    }

    @Test
    void testMutant_cuandoAdnnoEsMutante_regresaFalso() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };

        assertFalse(personaService.mutant(dna), "Should return false for non-mutant DNA");
    }

    @Test
    void testSave_personaesGuardad() {
        Persona persona = new Persona();
        persona.setAdn(Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"));
        persona.setMutant(true);

        // Simular el comportamiento del repositorio
        when(personaRepository.save(any(Persona.class))).thenReturn(persona);

        Persona savedPersona = personaService.save(persona);

        assertNotNull(savedPersona, "Saved persona should not be null");
        assertTrue(savedPersona.isMutant(), "Saved persona should be mutant");
    }
}
