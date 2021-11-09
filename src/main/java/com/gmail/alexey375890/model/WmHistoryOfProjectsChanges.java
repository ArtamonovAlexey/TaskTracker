package com.gmail.alexey375890.model;

import javax.persistence.*;
import java.util.List;
///
@Entity
@Table(name = "WM_HISTORY_OF_PROJECTS_CHANGES")
public class WmHistoryOfProjectsChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_NUMBER", referencedColumnName = "OUID", nullable = false)
    private WmProjects number;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_DEVELOP", referencedColumnName = "OUID", nullable = false)
    private List<WmDevelopments> develop;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE", nullable = false)
    private String endDate;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_RESPON_COMPANY", referencedColumnName = "OUID", nullable = false)
    private WmPeople responCompany;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_RESPON_OF_CLIENT_COMPANY", referencedColumnName = "OUID", nullable = false)
    private WmPeople responOfClientCompany;

    public WmHistoryOfProjectsChanges(WmProjects number, List<WmDevelopments> develop, String startDate,
                                      WmPeople responCompany, WmPeople responOfClientCompany) {
        this.number = number;
        this.develop = develop;
        this.startDate = startDate;
        this.responCompany = responCompany;
        this.responOfClientCompany = responOfClientCompany;
    }

    public WmHistoryOfProjectsChanges() {
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
        return "WmHistoryOfProjectsChanges{" +
                "id=" + id +
                ", number=" + number +
                ", develop=" + develop +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", responCompany=" + responCompany +
                ", responOfClientCompany=" + responOfClientCompany +
                '}';
    }
}
