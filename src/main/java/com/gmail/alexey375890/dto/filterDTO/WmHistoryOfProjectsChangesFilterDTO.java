package com.gmail.alexey375890.dto.filterDTO;

public class WmHistoryOfProjectsChangesFilterDTO {
    private Long projectId;

    private String startDate;
    private String endDate;

    private Long responCompanyId;

    private Long responOfClientCompanyId;

    private Long statusId;

    public WmHistoryOfProjectsChangesFilterDTO(Long projectId, String startDate, String endDate,
                                               Long responCompanyId, Long responOfClientCompanyId, Long statusId) {
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.responCompanyId = responCompanyId;
        this.responOfClientCompanyId = responOfClientCompanyId;
        this.statusId = statusId;
    }

    public WmHistoryOfProjectsChangesFilterDTO() {
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

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
