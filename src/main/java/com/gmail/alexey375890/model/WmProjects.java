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

    public WmProjects(String title, WmPeople author, WmCompanies company) {
        this.title = title;
        this.author = author;
        this.company = company;
    }

    public WmProjects() {
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

    @Override
    public String toString() {
        return "WmProjects{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", company=" + company +
                '}';
    }
}
