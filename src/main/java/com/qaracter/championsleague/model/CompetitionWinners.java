package com.qaracter.championsleague.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class that defines the winners of a football league.
 */
@Entity
@IdClass(CompetitionWinners.class)
@Table(name = "CompetitionWinners")
public class CompetitionWinners implements Serializable {
    @Column(nullable = false)
    private Long teamId;

    @Id
    private String season;

    @Id
    private Long competitionId;

    /**
     * Default constructor
     */
    public CompetitionWinners() { }

    /**
     * Constructor for a group of a team's victories in a Competition
     *
     * @param competitionId League where the team won
     * @param teamId Team that has won the league.
     * @param season Years when the team has won the league.
     *
     */
    public CompetitionWinners(Long competitionId, Long teamId, String season) {
        this.competitionId = competitionId;
        this.teamId = teamId;
        this.season = season;
    }

    /**
     * Getters & Setters.
     */
    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * Comparator between Competition Winners.
     *
     * @param o CompetitionWinners object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CompetitionWinners))
            return false;
        CompetitionWinners competitionWinners = (CompetitionWinners) o;
        return Objects.equals(this.competitionId, competitionWinners.competitionId)
                && Objects.equals(this.teamId, competitionWinners.teamId)
                && Objects.equals(this.season, competitionWinners.season);
    }

    /**
     * Shows Competition Winner's victories.
     *
     */
    @Override
    public String toString() {
        return "Competition Winners{" + "Competition = " + competitionId
                + ", team = '" + teamId + ", name = '" + season + '\'' + '}';
    }
}
