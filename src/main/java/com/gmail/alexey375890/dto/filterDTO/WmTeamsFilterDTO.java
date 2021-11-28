package com.gmail.alexey375890.dto.filterDTO;

public class WmTeamsFilterDTO {

    private Long personId;

    private Long developId;

    private String startDate;
    private String endDate;

    private Long statusId;

    public WmTeamsFilterDTO(Long personId, Long developId, String startDate, String endDate, Long statusId) {
        this.personId = personId;
        this.developId = developId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statusId = statusId;
    }

    public WmTeamsFilterDTO() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getDevelopId() {
        return developId;
    }

    public void setDevelopId(Long developId) {
        this.developId = developId;
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
