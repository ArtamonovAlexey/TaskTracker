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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_STATUS", referencedColumnName = "OUID", nullable = false)
    private WmStatus status;

    public WmCompanies(Long id, String name, WmStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public WmCompanies() {
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

    public WmStatus getStatus() {
        return status;
    }

    public void setStatus(WmStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WmCompanies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

}
