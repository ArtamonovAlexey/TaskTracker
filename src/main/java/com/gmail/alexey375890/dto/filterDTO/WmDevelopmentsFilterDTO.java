package com.gmail.alexey375890.dto.filterDTO;

public class WmDevelopmentsFilterDTO {
    private Long projectId;

    private Long UpdatedId;

    private String date1;
    private String date2;

    private Long trackerId;

    private String startDate;
    private String endDate;

    private Long statusId;

    public WmDevelopmentsFilterDTO(Long projectId, Long updatedId, String date1, String date2,
                                   Long trackerId, String startDate, String endDate, Long statusId) {
        this.projectId = projectId;
        UpdatedId = updatedId;
        this.date1 = date1;
        this.date2 = date2;
        this.trackerId = trackerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statusId = statusId;
    }

    public WmDevelopmentsFilterDTO() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUpdatedId() {
        return UpdatedId;
    }

    public void setUpdatedId(Long updatedId) {
        UpdatedId = updatedId;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
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

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
