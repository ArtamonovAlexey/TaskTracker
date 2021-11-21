package com.gmail.alexey375890.model;

import javax.persistence.*;
import java.util.Objects;

///
@Entity
@Table(name = "WM_STATUS")
public class WmStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUID")
    private Long id;

    @Column(name = "A_NAME", nullable = false)
    private String name;

    public WmStatus(String name) {
        this.name = name;
    }

    public WmStatus() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WmStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WmStatus wmStatus = (WmStatus) o;
        return Objects.equals(id, wmStatus.id) && Objects.equals(name, wmStatus.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
