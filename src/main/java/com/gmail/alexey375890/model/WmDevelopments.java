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
    @JoinColumn(name = "UPDATED", referencedColumnName = "OUID")
    private WmPeople updated;

    @Column(name = "UPDATE_TIME")
    private String updateTime;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_TRACKER", referencedColumnName = "OUID", nullable = false)
    private WmTracker tracker;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_STATUS", referencedColumnName = "OUID", nullable = false)
    private WmStatus status;

    public WmDevelopments(WmTracker tracker, String startDate, WmStatus status) {
        this.tracker = tracker;
        this.startDate = startDate;
        this.status = status;
    }

    public WmDevelopments() {
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
