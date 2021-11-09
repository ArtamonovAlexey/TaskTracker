package com.gmail.alexey375890.dto;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmStatus;

public class WmTasksDTO {
    private String name;

    private WmStatus status;

    private WmDevelopments develop;

    public WmTasksDTO(String name, WmStatus status, WmDevelopments develop) {
        this.name = name;
        this.status = status;
        this.develop = develop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WmStatus getStatus() {
        return status;
    }

    public void setStatus(WmStatus status) {
        this.status = status;
    }

    public WmDevelopments getDevelop() {
        return develop;
    }

    public void setDevelop(WmDevelopments develop) {
        this.develop = develop;
    }

    @Override
    public String toString() {
        return "WmTasksDTO{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", develop=" + develop +
                '}';
    }
}
