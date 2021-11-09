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

    public WmPeople(String surname, String firstName) {
        this.surname = surname;
        this.firstName = firstName;
    }

    public WmPeople() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
