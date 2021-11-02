package com.qaracter.championsleague.repository;

import com.qaracter.championsleague.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long>{

    Optional<Team> findTeamByName(String name);
}
