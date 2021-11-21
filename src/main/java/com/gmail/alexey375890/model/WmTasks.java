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
    @JoinColumn(name = "A_DEVELOP", referencedColumnName = "OUID")
    private WmDevelopments develop;

    public WmTasks(Long id, String name, String date, WmStatus status, WmDevelopments develop) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
        this.develop = develop;
    }

    public WmTasks() {
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

    public WmDevelopments getDevelop() {
        return develop;
    }

    public void setDevelop(WmDevelopments develop) {
        this.develop = develop;
    }

    @Override
    public String toString() {
        return "WmTasks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", wmDevelopments=" + develop +
                '}';
    }
}
