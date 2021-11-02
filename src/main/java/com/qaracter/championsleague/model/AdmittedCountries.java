package com.qaracter.championsleague.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class that defines a League model.
 */
@Entity
@IdClass(AdmittedCountries.class)
@Table(name = "admitted_countries")
public class AdmittedCountries implements Serializable {
    @Id
    private Long competitionId;

    @Id
    private String countryISO;

    /**
     * Default constructor
     */
    public AdmittedCountries() { }

    /**
     * Constructor for the admitted countries in a football competition
     *
     * @param countryISO Admitted Country.
     *
     */
    public AdmittedCountries(Long competitionId, String countryISO) {
        this.competitionId = competitionId;
        this.countryISO = countryISO;
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

    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO = countryISO;
    }

    /**
     * Checks if a country is admitted to the competition.
     *
     * @param o Country object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AdmittedCountries))
            return false;
        AdmittedCountries admittedCountries = (AdmittedCountries) o;
        return Objects.equals(this.competitionId, admittedCountries.competitionId)
                && Objects.equals(this.countryISO, admittedCountries.countryISO);
    }

    /**
     * Shows Admitted Countries in a Competition
     */
    @Override
    public String toString() {
        return "Admitted Countries{" + "id = " + competitionId + ", name = '" + countryISO + '\'' + '}';
    }
}
