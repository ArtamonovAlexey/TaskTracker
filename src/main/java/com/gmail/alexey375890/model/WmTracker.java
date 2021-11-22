package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_TRACKER")
public class WmTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @Column(name = "A_NAME", nullable = false)
    private String name;

    public WmTracker(String name) {
        this.name = name;
    }

    public WmTracker() {
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

    @Override
    public String toString() {
        return "WmTracker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
