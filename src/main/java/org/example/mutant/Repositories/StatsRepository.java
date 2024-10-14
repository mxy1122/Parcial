package org.example.mutant.Repositories;

import org.example.mutant.Entities.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stat,Long> {
}
