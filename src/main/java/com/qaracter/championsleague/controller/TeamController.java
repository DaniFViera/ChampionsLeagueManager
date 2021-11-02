package com.qaracter.championsleague.controller;

import com.qaracter.championsleague.model.Team;
import com.qaracter.championsleague.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Petitions manager. Allows to interact with the database
 */
@RestController
class TeamController {
    private final TeamRepository teamRepository;

    /**
     * Constructor
     *
     * @param teamRepository
     */
    TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    /**
     * Returns all the preset teams in the database
     */
    @GetMapping("/teams")
    List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    /**
     * Allows to create a team in the database if it wasn't inserted before
     *
     * @param newTeam Team to insert with all its params trough a JSON file
     */
    @PostMapping("/teams")
    Team createTeam(@RequestBody Team newTeam) {
        if (teamRepository.findTeamByName(newTeam.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return teamRepository.save(newTeam);
    }

    /**
     * Show a chosen team based on its id
     *
     * @param id Team's unique identifier added at the end of the endpoint
     */
    @GetMapping("/teams/{id}")
    Team getTeam(@PathVariable Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Allows to modify a previously inserted Team in the database
     *
     * @param newTeam Team to insert with all its new params trough a JSON file
     * @param id Team's unique identifier added at the end of the endpoint
     */
    @PutMapping("/teams/{id}")
    Team modifyTeam(@RequestBody Team newTeam, @PathVariable Long id) {
        if (teamRepository.findTeamByName(newTeam.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(newTeam.getName());
                    team.setCountry(newTeam.getCountry());
                    team.setBadge(newTeam.getBadge());
                    team.setRival(newTeam.getRival());
                    return teamRepository.save(team);
                })
                .orElseGet(() -> {
                    newTeam.setId(id);
                    return teamRepository.save(newTeam);
                });
    }

    /**
     * Allows to remove a Team previously inserted in the database through its id
     *
     * @param id Team's unique identifier added at the end of the endpoint
     */
    @DeleteMapping("/teams/{id}")
    void deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
    }
}