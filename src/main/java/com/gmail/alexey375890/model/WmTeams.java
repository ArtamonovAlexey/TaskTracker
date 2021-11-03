package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_TEAMS")
public class WmTeams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_PERSON", referencedColumnName = "OUID", nullable = false)
    private WmPeople person;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_TEAM", referencedColumnName = "OUID", nullable = false)
    private WmDevelopments team;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

}
