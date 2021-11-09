package com.gmail.alexey375890.dto;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;

import java.util.List;

public class WmHistoryOfProjectsChangesDTO {
    private WmProjects number;

    private List<WmDevelopments> develop;

    private String startDate;

    private WmPeople responCompany;

    private WmPeople responOfClientCompany;

    public WmHistoryOfProjectsChangesDTO(WmProjects number, List<WmDevelopments> develop, String startDate,
                                         WmPeople responCompany, WmPeople responOfClientCompany) {
        this.number = number;
        this.develop = develop;
        this.startDate = startDate;
        this.responCompany = responCompany;
        this.responOfClientCompany = responOfClientCompany;
    }

    public WmProjects getNumber() {
        return number;
    }

    public void setNumber(WmProjects number) {
        this.number = number;
    }

    public List<WmDevelopments> getDevelop() {
        return develop;
    }

    public void setDevelop(List<WmDevelopments> develop) {
        this.develop = develop;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public WmPeople getResponCompany() {
        return responCompany;
    }

    public void setResponCompany(WmPeople responCompany) {
        this.responCompany = responCompany;
    }

    public WmPeople getResponOfClientCompany() {
        return responOfClientCompany;
    }

    public void setResponOfClientCompany(WmPeople responOfClientCompany) {
        this.responOfClientCompany = responOfClientCompany;
    }

    @Override
    public String toString() {
        return "WmHistoryOfProjectsChangesDTO{" +
                ", number=" + number +
                ", develop=" + develop +
                ", startDate='" + startDate + '\'' +
                ", responCompany=" + responCompany +
                ", responOfClientCompany=" + responOfClientCompany +
                '}';
    }
}
