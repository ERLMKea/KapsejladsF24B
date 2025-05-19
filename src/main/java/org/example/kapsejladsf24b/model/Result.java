package org.example.kapsejladsf24b.model;

import jakarta.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultID;

    private int position;

    private int point;

    private boolean finished;

    @ManyToOne
    @JoinColumn(name = "boatidfk", referencedColumnName = "boatID")
    private Sailboat sailboat;

    @ManyToOne
    @JoinColumn(name = "raceidfk", referencedColumnName = "raceID")
    private Race race;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Sailboat getSailboat() {
        return sailboat;
    }

    public void setSailboat(Sailboat sailboat) {
        this.sailboat = sailboat;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
