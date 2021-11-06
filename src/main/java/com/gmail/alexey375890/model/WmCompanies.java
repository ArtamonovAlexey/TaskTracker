package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_COMPANIES")
public class WmCompanies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @Column(name = "A_NAME", nullable = false)
    private String name;

    public WmCompanies(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public WmCompanies() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WmCompanies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
