package com.gmail.alexey375890.dto;

public class WmTeamsDTO {

    private Long id;

    private Long personId;

    private Long teamId;

    private String startDate;

    private String endDate;

    public WmTeamsDTO(Long id, Long personId, Long teamId, String startDate, String endDate) {
        this.id = id;
        this.personId = personId;
        this.teamId = teamId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public WmTeamsDTO() {
    }

    public Long getId() {
        return id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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
        return "WmTeamsDTO{" +
                "id=" + id +
                ", personId=" + personId +
                ", teamId=" + teamId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
