package com.gmail.alexey375890.dto;

public class WmHistoryOfProjectsChangesDTO {

    private Long id;

    private Long projectId;

    private String startDate;

    private String endDate;

    private Long responCompanyId;

    private Long responOfClientCompanyId;

    public WmHistoryOfProjectsChangesDTO(Long id, Long projectId, String startDate,
                                         String endDate, Long responCompanyId, Long responOfClientCompanyId) {
        this.id = id;
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.responCompanyId = responCompanyId;
        this.responOfClientCompanyId = responOfClientCompanyId;
    }

    public WmHistoryOfProjectsChangesDTO() {
    }

    public Long getId() {
        return id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public Long getResponCompanyId() {
        return responCompanyId;
    }

    public void setResponCompanyId(Long responCompanyId) {
        this.responCompanyId = responCompanyId;
    }

    public Long getResponOfClientCompanyId() {
        return responOfClientCompanyId;
    }

    public void setResponOfClientCompanyId(Long responOfClientCompanyId) {
        this.responOfClientCompanyId = responOfClientCompanyId;
    }

    @Override
    public String toString() {
        return "WmHistoryOfProjectsChangesDTO{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", responCompanyId=" + responCompanyId +
                ", responOfClientCompanyId=" + responOfClientCompanyId +
                '}';
    }
}
