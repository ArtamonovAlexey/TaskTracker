package com.gmail.alexey375890.dto;

public class WmTasksDTO {

    private Long id;

    private String name;

    private Long developId;

    public WmTasksDTO(Long id, String name, Long developId) {
        this.id = id;
        this.name = name;
        this.developId = developId;
    }

    public WmTasksDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDevelopId() {
        return developId;
    }

    public void setDevelopId(Long developId) {
        this.developId = developId;
    }

    @Override
    public String toString() {
        return "WmTasksDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developId=" + developId +
                '}';
    }
}
