package com.gmail.alexey375890.dto;

public class WmDevelopmentsDTO {

    private Long id;

    private Long projectId;

    private Long trackerId;

    private String startDate;

    private String endDate;

    public WmDevelopmentsDTO(Long id, Long projectId, Long trackerId, String startDate, String endDate) {
        this.id = id;
        this.projectId = projectId;
        this.trackerId = trackerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public WmDevelopmentsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Long trackerId) {
        this.trackerId = trackerId;
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
        return "WmDevelopmentsDTO{" +
                "id=" + id +
                ", tracker=" + trackerId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

}
