package com.gmail.alexey375890.dto;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;

public class WmTeamsDTO {
    private WmPeople person;

    private WmDevelopments team;

    private String startDate;

    public WmTeamsDTO(WmPeople person, WmDevelopments team, String startDate) {
        this.person = person;
        this.team = team;
        this.startDate = startDate;
    }

    public WmPeople getPerson() {
        return person;
    }

    public void setPerson(WmPeople person) {
        this.person = person;
    }

    public WmDevelopments getTeam() {
        return team;
    }

    public void setTeam(WmDevelopments team) {
        this.team = team;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "WmTeamsTeamsDTO{" +
                "person=" + person +
                ", team=" + team +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
