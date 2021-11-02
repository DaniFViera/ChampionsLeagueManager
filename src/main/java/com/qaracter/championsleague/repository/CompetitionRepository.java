package com.qaracter.championsleague.repository;

import com.qaracter.championsleague.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    Optional<Competition> findCompByName(String name);
}
