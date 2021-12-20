package com.example.kommunevalg.Model;

import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "politicalParty")
    private String politicalParty;

    @Column(name = "votes")
    private int votes;

    // Tom constructor til JPA
    public Candidate() {
    }

    // Constructor der bruges i Database setup
    public Candidate(String name, String politicalParty, int votes) {
        this.name = name;
        this.politicalParty = politicalParty;
        this.votes = votes;
    }

    // Getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
