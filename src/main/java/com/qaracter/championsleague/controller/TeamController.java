package com.qaracter.championsleague.controller;

import com.qaracter.championsleague.model.Team;
import com.qaracter.championsleague.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
class TeamController {
    private final TeamRepository teamRepository;

    TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @PostMapping("/teams")
    Team createTeam(@RequestBody Team newTeam) {
        if (teamRepository.findByName(newTeam.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return teamRepository.save(newTeam);
    }

    @GetMapping("/teams/{id}")
    Team getTeam(@PathVariable Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/teams/{id}")
    Team modifyTeam(@RequestBody Team newTeam, @PathVariable Long id) {
        if (teamRepository.findByName(newTeam.getName()).isPresent()) {
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

    @DeleteMapping("/teams/{id}")
    void deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
    }
}