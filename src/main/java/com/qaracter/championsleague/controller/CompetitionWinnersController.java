package com.qaracter.championsleague.controller;

import com.qaracter.championsleague.model.CompetitionWinners;
import com.qaracter.championsleague.repository.CompetitionWinnersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CompetitionWinnersController {
    private final CompetitionWinnersRepository competitionWinnersRepository;

    /**
     * Constructor
     *
     * @param competitionWinnersRepository
     */
    CompetitionWinnersController(CompetitionWinnersRepository competitionWinnersRepository) {
        this.competitionWinnersRepository = competitionWinnersRepository;
    }

    /**
     * Returns all the preset winner teams in the database
     */
    @GetMapping("/competitionWinnerTeams")
    List<CompetitionWinners> getAllTeams() {
        return competitionWinnersRepository.findAll();
    }

    /**
     * Allows to create a winner team in the database if it wasn't inserted before
     *
     * @param newTeam Winner team to insert with all its params trough a JSON file
     */
/*    @PostMapping("/competitionWinnerTeams")
    CompetitionWinners createTeam(@RequestBody CompetitionWinners newTeam) {
        if (competitionWinnersRepository.findCompWinnerBySeason(newTeam.getSeason()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return competitionWinnersRepository.save(newTeam);
    }*/

    /**
     * Show a chosen winner team based on its id
     *
     * @param id Team's unique identifier added at the end of the endpoint
     */
/*    @GetMapping("/competitionWinnerTeams/{id}")
    CompetitionWinners getTeam(@PathVariable Long id) {
        return competitionWinnersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }*/

    /**
     * Allows to modify a previously inserted Winner Team in the database
     *
     * @param newTeam Winner team to insert with all its new params trough a JSON file
     * @param id Competition's unique identifier added at the end of the endpoint
     */
/*    @PutMapping("/competitionWinnerTeams/{id}")
    CompetitionWinners modifyTeam(@RequestBody CompetitionWinners newTeam, @PathVariable Long id) {
        if (!competitionWinnersRepository.findCompWinnerBySeason(newTeam.getSeason()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return competitionWinnersRepository.findById(id)
                .map(winnerTeam -> {
                    winnerTeam.setSeason(newTeam.getSeason());
                    winnerTeam.setTeamId(newTeam.getTeamId());
                    return competitionWinnersRepository.save(winnerTeam);
                })
                .orElseGet(() -> {
                    newTeam.setCompetitionId(id);
                    return competitionWinnersRepository.save(newTeam);
                });
    }*/

    /**
     * Allows to remove a Winner Team previously inserted in the database through its id
     *
     * @param id Team's unique identifier added at the end of the endpoint
     */
/*    @DeleteMapping("/competitionWinnerTeams/{id}")
    void deleteTeam(@PathVariable Long id) {
        competitionWinnersRepository.deleteById(id);
    }*/
}
