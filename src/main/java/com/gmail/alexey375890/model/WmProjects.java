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

}
