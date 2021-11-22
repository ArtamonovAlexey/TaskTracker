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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_STATUS", referencedColumnName = "OUID", nullable = false)
    private WmStatus status;

    public WmPeople(Long id, String surname, String firstName, String secondName, WmStatus status) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.status = status;
    }

    public WmPeople() {
    }

    public Long getId() {
        return id;
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

    public WmStatus getStatus() {
        return status;
    }

    public void setStatus(WmStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WmPeople{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
