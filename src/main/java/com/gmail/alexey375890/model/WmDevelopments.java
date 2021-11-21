package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_DEVELOPMENTS")
public class WmDevelopments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_PROJECT", referencedColumnName = "OUID")
    private WmHistoryOfProjectsChanges project;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "UPDATED", referencedColumnName = "OUID")
    private WmPeople updated;

    @Column(name = "UPDATE_TIME")
    private String updateTime;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_TRACKER", referencedColumnName = "OUID")
    private WmTracker tracker;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_STATUS", referencedColumnName = "OUID", nullable = false)
    private WmStatus status;

    public WmDevelopments(Long id, WmHistoryOfProjectsChanges project,
                          WmPeople updated, String updateTime, WmTracker tracker,
                          String startDate, String endDate, WmStatus status
    ) {
        this.id = id;
        this.project = project;
        this.updated = updated;
        this.updateTime = updateTime;
        this.tracker = tracker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public WmDevelopments(Long id, WmPeople updated, String updateTime, WmTracker tracker,
                          String startDate, String endDate, WmStatus status) {
        this.id = id;
        this.updated = updated;
        this.updateTime = updateTime;
        this.tracker = tracker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public WmDevelopments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WmHistoryOfProjectsChanges getProject() {
        return project;
    }

    public void setProject(WmHistoryOfProjectsChanges project) {
        this.project = project;
    }

    public WmPeople getUpdated() {
        return updated;
    }

    public void setUpdated(WmPeople updated) {
        this.updated = updated;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public WmTracker getTracker() {
        return tracker;
    }

    public void setTracker(WmTracker tracker) {
        this.tracker = tracker;
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

    public WmStatus getStatus() {
        return status;
    }

    public void setStatus(WmStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WmDevelopments{" +
                "id=" + id +
                ", updated=" + updated +
                ", updateTime='" + updateTime + '\'' +
                ", tracker=" + tracker +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status=" + status +
                '}';
    }

}
