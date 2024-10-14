package org.example.mutant.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected  Long Id;

    @ElementCollection //Usar ElementCollection para almacenar una lista de cadenaswd
    protected List<String> adn ;

    private boolean isMutant;

}
