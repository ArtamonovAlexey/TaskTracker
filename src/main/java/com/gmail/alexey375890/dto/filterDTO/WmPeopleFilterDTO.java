package com.gmail.alexey375890.dto.filterDTO;

public class WmPeopleFilterDTO {

    private String surname;

    private String firstName;

    private String secondName;

    private Long statusId;

    public WmPeopleFilterDTO(String surname, String firstName, String secondName, Long statusId) {
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.statusId = statusId;
    }

    public WmPeopleFilterDTO() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
