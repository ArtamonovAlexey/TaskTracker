package com.gmail.alexey375890.model;

import com.gmail.alexey375890.enums.Role;
import com.gmail.alexey375890.enums.Status;

import javax.persistence.*;

@Entity
@Table(name = "WM_USERS")
public class WmUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "A_PERSON", referencedColumnName = "OUID")
    private WmPeople person;

    @Column(name = "AN_USERNAME")
    private String username;

    @Column(name = "A_PASSWORD")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "A_ROLE", nullable = false)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "A_STATUS", nullable = false)
    private Status status;

    public WmUsers(Long id, WmPeople person, String username, String password, Role role, Status status) {
        this.id = id;
        this.person = person;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public WmUsers() {
    }

    public Long getId() {
        return id;
    }

    public WmPeople getPerson() {
        return person;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

    public void setPerson(WmPeople person) {
        this.person = person;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WmUsers{" +
                "id=" + id +
                ", person=" + person +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
