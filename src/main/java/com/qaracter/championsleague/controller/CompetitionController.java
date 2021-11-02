package com.qaracter.championsleague.controller;

import com.qaracter.championsleague.model.Competition;
import com.qaracter.championsleague.model.CompetitionWinners;
import com.qaracter.championsleague.repository.CompetitionRepository;
import com.qaracter.championsleague.repository.CompetitionWinnersRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Competition petitions manager. Allows to interact with the database
 */
@RestController
class CompetitionController {
    private final CompetitionRepository competitionRepository;

    /**
     * Constructor
     *
     * @param competitionRepository
     */
    CompetitionController(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    /**
     * Returns all the preset competitions in the database
     */
    @GetMapping("/competitions")
    List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    /**
     * Allows to create a Competition in the database if it wasn't inserted before
     *
     * @param newComp Competition to insert with all its params trough a JSON file
     */
    @PostMapping("/competitions")
    Competition createCompetition(@RequestBody Competition newComp) {
        if (competitionRepository.findCompByName(newComp.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return competitionRepository.save(newComp);
    }

    /**
     * Show a chosen competition based on its id
     *
     * @param id Competition's unique identifier added at the end of the endpoint
     */
    @GetMapping("/competitions/{id}")
    Competition getCompetition(@PathVariable Long id) {
        return competitionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Allows to modify a previously inserted Team in the database
     *
     * @param newComp Team to insert with all its new params trough a JSON file
     * @param id      Team's unique identifier added at the end of the endpoint
     */
    @PutMapping("/competitions/{id}")
    Competition modifyTeam(@RequestBody Competition newComp, @PathVariable Long id) {
        if (competitionRepository.findCompByName(newComp.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return competitionRepository.findById(id)
                .map(competition -> {
                    competition.setName(newComp.getName());
                    return competitionRepository.save(competition);
                })
                .orElseGet(() -> {
                    newComp.setId(id);
                    return competitionRepository.save(newComp);
                });
    }

    /**
     * Allows to remove a Team previously inserted in the database through its id
     *
     * @param id Team's unique identifier added at the end of the endpoint
     */
    @DeleteMapping("/competitions/{id}")
    void deleteTeam(@PathVariable Long id) {
        competitionRepository.deleteById(id);
    }

    /**
     * Show a chosen team based on its name and its competition titles if it has them
     *
     */
/*    @GetMapping("/competitions/{id}/winners")
    @Query(value = "SELECT cw.season FROM CompetitionWinners cw INNER JOIN" +
            "cw.teamId WHERE cw.teamId = Teams.id AND Teams.name = :teamName")
    List<CompetitionWinners> getWinnerTeams(@RequestParam("teamName") String teamName,
                                            @RequestParam("season") String season,
                                            @PathVariable Long id) {
        return competitionRepository.findAll().contains(teamName)
        return CompetitionWinnersRepository.findCompWinnerByName(teamName);
    }*/
}