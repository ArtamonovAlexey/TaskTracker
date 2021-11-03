package com.gmail.alexey375890.model;

import javax.persistence.*;
import java.util.List;
///
@Entity
@Table(name = "WM_HISTORY_OF_PROJECTS_CHANGES")
public class WmHistoryOfProjectsChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_NUMBER", referencedColumnName = "OUID", nullable = false)
    private WmProjects number;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_DEVELOP", referencedColumnName = "OUID", nullable = false)
    private List<WmDevelopments> develop;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE", nullable = false)
    private String endDate;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_RESPON_COMPANY", referencedColumnName = "OUID", nullable = false)
    private WmPeople responCompany;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_RESPON_OF_CLIENT_COMPANY", referencedColumnName = "OUID", nullable = false)
    private WmPeople responOfClientCompany;

}
