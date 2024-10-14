package org.example.mutant.Service;

import org.example.mutant.Entities.Stat;
import org.example.mutant.Repositories.PersonaRepository;
import org.example.mutant.Entities.Persona;
import org.example.mutant.Repositories.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private StatsRepository statsRepository;


    public boolean mutant(String[] dna) {
        int countDnaEquals = 0;

        // Verificaciones horizontales
        for (int fil = 0; fil < 6; fil++) {
            for (int i = 0; i < 3; i++) {
                if (dna[fil].charAt(i) == dna[fil].charAt(i + 1) &&
                        dna[fil].charAt(i + 1) == dna[fil].charAt(i + 2) &&
                        dna[fil].charAt(i + 2) == dna[fil].charAt(i + 3)) {
                    countDnaEquals++;
                }
            }
        }

        // Verificaciones verticales
        for (int col = 0; col < 6; col++) {
            for (int i = 0; i < 3; i++) {
                if (dna[i].charAt(col) == dna[i + 1].charAt(col) &&
                        dna[i + 1].charAt(col) == dna[i + 2].charAt(col) &&
                        dna[i + 2].charAt(col) == dna[i + 3].charAt(col)) {
                    countDnaEquals++;
                }
            }
        }

        // Verificaciones diagonales (principales de izquierda a derecha)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) &&
                        dna[i + 1].charAt(j + 1) == dna[i + 2].charAt(j + 2) &&
                        dna[i + 2].charAt(j + 2) == dna[i + 3].charAt(j + 3)) {
                    countDnaEquals++;
                }
            }
        }

        // Verificaciones diagonales (desde abajo hacia arriba, derecha a izquierda)
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j - 1) &&
                        dna[i + 1].charAt(j - 1) == dna[i + 2].charAt(j - 2) &&
                        dna[i + 2].charAt(j - 2) == dna[i + 3].charAt(j - 3)) {
                    countDnaEquals++;
                }
            }
        }

        // Si se encuentran más de una secuencia mutante, devolver true
        return countDnaEquals > 1;
    }

    public void verificarYGuardarMutante(Persona persona) {

        List<String> dna = persona.getAdn(); // Obtener las secuencias de ADN

        personaRepository.save(persona);

        String [] dnaArray = dna.toArray(new String[0]);

        if (mutant(dnaArray)) {
            System.out.println("El sujeto es mutante");
            // Aquí podrías agregar la lógica para guardar en la base de datos si es mutante
        } else {
            System.out.println("El sujeto no es mutante");
        }

    }



    public Persona AddPersona(String[] dna){

        Persona persona = new Persona();
        persona.setAdn(Arrays.asList(dna));
        return personaRepository.save(persona);

    }

    public long countMutants() {

        return personaRepository.countByIsMutantTrue();

    }

    public long countHumans() {

        return personaRepository.countByIsMutantFalse();

    }

    public Stat getStat() {
        long countMutants = countMutants();
        long countHumans = countHumans();

        // Calculamos el ratio
        double ratio = countHumans > 0 ? (double) countMutants / countHumans : 0.0;

        // Creamos la entidad Stats
        Stat stat = Stat.builder()
                .countMutantDna(countMutants)
                .countHumanDna(countHumans)
                .ratio(ratio)
                .build();

        // Guardamos o actualizamos las estadísticas en la base de datos
        statsRepository.save(stat);

        // Retornamos las estadísticas
        return stat;


        // Retornamos las estadísticas
        //Stat stats = Stat.builder().count;
    }
    public Persona save(Persona persona) {

       return personaRepository.save(persona);  // Guardar la persona en la base de datos

    }


}
