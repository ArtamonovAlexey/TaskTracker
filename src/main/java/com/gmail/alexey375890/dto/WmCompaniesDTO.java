package com.gmail.alexey375890.dto;

public class WmCompaniesDTO {

    private Long id;

    private String name;

    public WmCompaniesDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public WmCompaniesDTO() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
