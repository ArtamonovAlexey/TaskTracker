package com.gmail.alexey375890.model;

import javax.persistence.*;
///
@Entity
@Table(name = "WM_PEOPLE")
public class WmPeople {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @Column(name = "A_SURNAME", nullable = false)
    private String surname;

    @Column(name = "A_FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "A_SECOND_NAME")
    private String secondName;

}
