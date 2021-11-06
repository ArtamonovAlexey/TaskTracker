package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_DEVELOPMENTS")
public class WmDevelopments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "UPDATED", referencedColumnName = "OUID")
    private WmPeople updated;

    @Column(name = "UPDATE_TIME")
    private String updateTime;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_TRACKER", referencedColumnName = "OUID", nullable = false)
    private WmTracker tracker;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

//    @OneToMany(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "TASKS", referencedColumnName = "OUID", nullable = false)
//    private List<WmTasks> tasks;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_STATUS", referencedColumnName = "OUID", nullable = false)
    private WmStatus status;

}
