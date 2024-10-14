package org.example.mutant.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Stat{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "contarMutantes")
    private long countMutantDna;

    @Column(name = "contarHumanos")
    private long countHumanDna;

    @Column(name = "ratio")
    private double ratio;



}
