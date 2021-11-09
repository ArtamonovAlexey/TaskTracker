package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_TASKS")
public class WmTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @Column(name = "A_NAME", nullable = false)
    private String name;

    @Column(name = "A_DATE")
    private String date;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_STATUS", referencedColumnName = "OUID", nullable = false)
    private WmStatus status;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_DEVELOP", referencedColumnName = "OUID", nullable = false)
    private WmDevelopments wmDevelopments;

    public WmTasks(String name, WmStatus status, WmDevelopments wmDevelopments) {
        this.name = name;
        this.status = status;
        this.wmDevelopments = wmDevelopments;
    }

    public WmTasks() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WmStatus getStatus() {
        return status;
    }

    public void setStatus(WmStatus status) {
        this.status = status;
    }

    public WmDevelopments getWmDevelopments() {
        return wmDevelopments;
    }

    public void setWmDevelopments(WmDevelopments wmDevelopments) {
        this.wmDevelopments = wmDevelopments;
    }
}
