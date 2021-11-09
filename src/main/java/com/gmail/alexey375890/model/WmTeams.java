package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_TEAMS")
public class WmTeams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_PERSON", referencedColumnName = "OUID", nullable = false)
    private WmPeople person;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_TEAM", referencedColumnName = "OUID", nullable = false)
    private WmDevelopments team;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    public WmTeams(WmPeople person, WmDevelopments team, String startDate) {
        this.person = person;
        this.team = team;
        this.startDate = startDate;
    }

    public WmTeams() {
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "WmTeams{" +
                "id=" + id +
                ", person=" + person +
                ", team=" + team +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
