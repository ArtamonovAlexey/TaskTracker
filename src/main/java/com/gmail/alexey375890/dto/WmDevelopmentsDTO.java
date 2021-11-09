package com.gmail.alexey375890.dto;

import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTracker;

public class WmDevelopmentsDTO {
    private WmTracker tracker;

    private String startDate;

    private WmStatus status;

    public WmDevelopmentsDTO(WmTracker tracker, String startDate, WmStatus status) {
        this.tracker = tracker;
        this.startDate = startDate;
        this.status = status;
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

    public WmStatus getStatus() {
        return status;
    }

    public void setStatus(WmStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WmDevelopmentsDto{" +
                ", tracker=" + tracker +
                ", startDate='" + startDate + '\'' +
                ", status=" + status +
                '}';
    }
}
