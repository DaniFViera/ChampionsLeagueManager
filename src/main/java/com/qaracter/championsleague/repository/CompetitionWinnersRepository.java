package com.qaracter.championsleague.repository;

import com.qaracter.championsleague.model.CompetitionWinners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompetitionWinnersRepository extends JpaRepository<CompetitionWinners, Long> {
    //Optional<CompetitionWinners> findCompWinnerByName(String name);
    //Optional<CompetitionWinners> findCompWinnerBySeason(String season);
}