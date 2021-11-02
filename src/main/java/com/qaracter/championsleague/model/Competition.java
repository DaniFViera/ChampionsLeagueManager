package com.qaracter.championsleague.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class that defines a League model.
 */
@Entity
@Table(name = "Competitions")
public class Competition {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    /**
     * Default constructor
     */
    public Competition() { }

    /**
     * Constructor for a football competition
     *
     * @param name League's name.
     *
     */
    public Competition(String name) {
        this.name = name;
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

    /**
     * Comparator between objects from Competition class.
     *
     * @param o Competition object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Competition))
            return false;
        Competition competition = (Competition) o;
        return Objects.equals(this.id, competition.id)
                && Objects.equals(this.name, competition.name);
    }

    /**
     * Shows Competition's attributes.
     *
     */
    @Override
    public String toString() {
        return "Competition{" + "id = " + id + ", name = '" + name + '\'' + '}';
    }
}
