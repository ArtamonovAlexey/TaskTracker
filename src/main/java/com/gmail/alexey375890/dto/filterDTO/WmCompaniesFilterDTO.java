package com.gmail.alexey375890.dto.filterDTO;

public class WmCompaniesFilterDTO {

    private String name;

    private Long statusId;


    public WmCompaniesFilterDTO(String name, Long statusId) {
        this.name = name;
        this.statusId = statusId;
    }

    public WmCompaniesFilterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
