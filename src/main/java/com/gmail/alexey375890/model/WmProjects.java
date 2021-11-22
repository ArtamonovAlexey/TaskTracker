package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_PROJECTS")
public class WmProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @Column(name = "A_TITLE", nullable = false)
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "AN_AUTHOR", referencedColumnName = "OUID", nullable = false)
    private WmPeople author;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_CLIENT_COMPANY", referencedColumnName = "OUID", nullable = false)
    private WmCompanies company;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_STATUS", referencedColumnName = "OUID", nullable = false)
    private WmStatus status;

    public WmProjects(Long id, String title, WmPeople author, WmCompanies company, WmStatus status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.company = company;
        this.status = status;
    }

    public WmProjects() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WmPeople getAuthor() {
        return author;
    }

    public void setAuthor(WmPeople author) {
        this.author = author;
    }

    public WmCompanies getCompany() {
        return company;
    }

    public void setCompany(WmCompanies company) {
        this.company = company;
    }

    public WmStatus getStatus() {
        return status;
    }

    public void setStatus(WmStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WmProjects{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", company=" + company +
                ", status=" + status +
                '}';
    }
}
