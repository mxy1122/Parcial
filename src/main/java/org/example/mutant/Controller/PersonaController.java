package org.example.mutant.Controller;


import org.example.mutant.Entities.*;
import org.example.mutant.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/mutant")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/agregar")
    public ResponseEntity<String> VerificarAdn(@RequestBody Map<String,String[]> dnaRequest) {
        String[] dna = dnaRequest.get("dna");  // Obtener la secuencia de ADN desde el JSON

    // Crear la persona con el ADN proporcionado
        Persona persona = new Persona();
        persona.setAdn(Arrays.asList(dna));

    // Verificar si es mutante

        boolean esMutante = personaService.mutant(dna);
        persona.setMutant(esMutante); // Establecer si la persona es mutante o no

    // Guardar la persona en la base de datos con el estado isMutant correcto

        personaService.save(persona);
        if (personaService.mutant(dna)) {
            return ResponseEntity.ok("El individuo es mutante");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El individuo no es mutante");
        }

    }

    @GetMapping("/stats")
    public ResponseEntity<Stat> obtenerEstadisticas(){
        Stat stat = personaService.getStat();
        return ResponseEntity.ok(stat);

    }

}
