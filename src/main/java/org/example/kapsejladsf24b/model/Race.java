package org.example.kapsejladsf24b.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceID;

    private LocalDate raceStart;

    private BoatType boatType;

    @OneToMany(mappedBy = "race")
    @JsonBackReference
    private Set<Result> results = new HashSet<>();

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public LocalDate getRaceStart() {
        return raceStart;
    }

    public void setRaceStart(LocalDate raceStart) {
        this.raceStart = raceStart;
    }

    public BoatType getBoatType() {
        return boatType;
    }

    public void setBoatType(BoatType boatType) {
        this.boatType = boatType;
    }
}
