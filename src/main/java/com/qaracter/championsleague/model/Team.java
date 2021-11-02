package com.qaracter.championsleague.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class that defines a football team.
 */
@Entity
@Table(name = "teams")
public class Team {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column
    private String rival;

    @Column(nullable = false)
    //TODO: change this for URI type
    private String badge;

    /**
     * Default constructor
     */
    public Team() { }

    /**
     * Constructor for those teams without historic rival
     *
     * @param name Team's name.
     * @param country Team's country.
     * @param badge Team's badge.
     *
     */
    public Team(String name, String country, String badge) {
        this.name = name;
        this.country = country;
        this.badge = badge;
    }

    /**
     * Constructor for those teams with historic rival
     *
     * @param name Team's name.
     * @param country Team's country.
     * @param rival Team's historic rival
     * @param badge Team's badge.
     *
     */
    public Team(String name, String country, String rival, String badge) {
        this.name = name;
        this.country = country;
        this.rival = rival;
        this.badge = badge;
    }

    /**
     * Getters & Setters.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    /**
     * Comparator between objects from Team class.
     *
     * @param o Team object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Team))
            return false;
        Team team = (Team) o;
        return Objects.equals(this.id, team.id)
                && Objects.equals(this.name, team.name)
                && Objects.equals(this.country, team.country)
                && Objects.equals(this.rival, team.rival)
                && Objects.equals(this.badge, team.badge);
    }

    /**
     * Shows Team's attributes.
     *
     */
    @Override
    public String toString() {
        String a = "Team{" + "id =";
        Long b = this.id;
        String c = ", name = '" + this.name + '\'' + ", role ='" + this.country + '\'';
        String d = ", rival = '" + this.rival + '\'';
        String e = ", badge ='" + this.badge + '}';
        if(this.rival != null){
            System.out.println(a + b + c + d + e);
        } else {
            System.out.println(a + b + c + e);
        }
        return "";
    }
}
