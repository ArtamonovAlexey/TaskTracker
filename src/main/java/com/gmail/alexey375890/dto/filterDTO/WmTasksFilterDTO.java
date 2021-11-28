package com.gmail.alexey375890.dto.filterDTO;

public class WmTasksFilterDTO {

    private String name;

    private String date1;
    private String date2;

    private Long developId;

    private Long statusId;

    public WmTasksFilterDTO(String name, String date1, String date2, Long developId, Long statusId) {
        this.name = name;
        this.date1 = date1;
        this.date2 = date2;
        this.developId = developId;
        this.statusId = statusId;
    }

    public WmTasksFilterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getDevelopId() {
        return developId;
    }

    public void setDevelopId(Long developId) {
        this.developId = developId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
